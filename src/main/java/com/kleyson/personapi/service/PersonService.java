package com.kleyson.personapi.service;

import com.kleyson.personapi.dto.request.PersonDTO;
import com.kleyson.personapi.entity.Person;
import com.kleyson.personapi.exceptions.PersonNotFoundException;
import com.kleyson.personapi.mapper.PersonMapper;
import com.kleyson.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    private final PersonRepository repository;
    private final PersonMapper personMapper;

    public PersonDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = repository.save(personToSave);
        return personMapper.toDTO(savedPerson);
    }

    public List<PersonDTO> getAllPersons(){
        List<Person> persons = repository.findAll();

        return persons.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO getPersonById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    public void deletePerson(Long id) throws PersonNotFoundException{
        verifyIfExists(id);
        repository.deleteById(id);
    }

    public PersonDTO updatePerson(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        Person personChanges = personMapper.toModel(personDTO);
        Person updatedPerson = repository.save(personChanges);
        return personMapper.toDTO(updatedPerson);
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return repository
                .findById(id)
                .orElseThrow(
                        () -> new PersonNotFoundException("No persons were found with this ID")
                );
    }
}
