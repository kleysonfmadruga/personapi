package com.kleyson.personapi.controller;

import com.kleyson.personapi.dto.request.PersonDTO;
import com.kleyson.personapi.entity.Person;
import com.kleyson.personapi.exceptions.PersonNotFoundException;
import com.kleyson.personapi.service.PersonService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class PersonController {
    private final PersonService service;

    @Autowired
    public PersonController(PersonService service){
        this.service = service;
    }

    @PostMapping("/api/v1/persons")
    public ResponseEntity<?> createPerson(@RequestBody @Valid PersonDTO personDTO){
        try {
            PersonDTO savedPerson = service.createPerson(personDTO);
            return ResponseEntity
                    .created(URI.create("/persons/" + savedPerson.getId()))
                    .eTag(savedPerson.getId().toString()).body(savedPerson);

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/api/v1/persons")
    public ResponseEntity<?> getAllPersons(){
        List<PersonDTO> persons = service.getAllPersons();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/api/v1/persons/{id}")
    public ResponseEntity<?> getPerson(@PathVariable Long id){
        try {
            PersonDTO person = service.getPersonById(id);
            return ResponseEntity.ok(person);
        } catch (PersonNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/api/v1/persons/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id){
        try {
            service.deletePerson(id);
            return ResponseEntity.noContent().build();
        } catch (PersonNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
