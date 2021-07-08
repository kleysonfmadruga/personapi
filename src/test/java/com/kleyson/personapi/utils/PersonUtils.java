package com.kleyson.personapi.utils;

import com.kleyson.personapi.dto.request.PersonDTO;
import com.kleyson.personapi.entity.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {
    private static final String cpf = "258.574.520-15";
    private static final String firstName = "José Maria";
    private static final String lastName = "da Silva";
    private static final String stringBirthDate = "01-01-1999";
    private static final LocalDate birthDate = LocalDate.of(1999, 1, 1);
    private static final Long id = 1L;

    public static PersonDTO createFakeDTO(){
        return PersonDTO
                .builder()
                .id(id)
                .cpf(cpf)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(stringBirthDate)
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity(){
        return Person
                .builder()
                .id(id)
                .cpf(cpf)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
