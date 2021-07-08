package com.kleyson.personapi.service;

import com.kleyson.personapi.dto.request.PersonDTO;
import com.kleyson.personapi.entity.Person;
import com.kleyson.personapi.mapper.PersonMapper;
import com.kleyson.personapi.repository.PersonRepository;
import com.kleyson.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.kleyson.personapi.utils.PersonUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;
    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedPersonDTO() {
        PersonDTO person = createFakeDTO();
        when(personService.createPerson(person)).thenReturn(person);

        assertEquals(person, personService.createPerson(person));
    }
}
