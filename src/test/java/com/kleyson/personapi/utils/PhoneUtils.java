package com.kleyson.personapi.utils;

import com.kleyson.personapi.dto.request.PhoneDTO;
import com.kleyson.personapi.entity.Phone;
import com.kleyson.personapi.enums.PhoneType;

public class PhoneUtils {
    private static final String number = "5583994447568";
    private static final PhoneType type = PhoneType.COMMERCIAL;
    private static final Long id = 1L;

    public static PhoneDTO createFakeDTO(){
        return PhoneDTO
                .builder()
                .id(id)
                .number(number)
                .type(type)
                .build();
    }

    public static Phone createFakeEntity(){
        return Phone
                .builder()
                .id(id)
                .number(number)
                .type(type)
                .build();
    }
}
