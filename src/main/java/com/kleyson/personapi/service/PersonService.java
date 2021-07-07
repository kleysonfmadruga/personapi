package com.kleyson.personapi.service;

import com.kleyson.personapi.dto.request.PersonDTO;
import com.kleyson.personapi.entity.Person;
import com.kleyson.personapi.exceptions.PersonNotFoundException;
import com.kleyson.personapi.mapper.PersonMapper;
import com.kleyson.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository repository;
    private final PersonMapper personMapper;

    @Autowired
    public PersonService(PersonRepository repository, PersonMapper personMapper){
        this.repository = repository;
        this.personMapper = personMapper;
    }

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
        Person person = repository
                .findById(id)
                .orElseThrow(
                    () -> new PersonNotFoundException("No persons were found with this ID")
                );

        return personMapper.toDTO(person);
    }
}
