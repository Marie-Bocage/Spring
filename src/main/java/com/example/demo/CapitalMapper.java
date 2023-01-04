package com.example.demo;

public class CapitalMapper {

    public static CapitalDto convertToDto(Country capital) {
        CapitalDto dto = new CapitalDto();
        dto.setCapitalName(capital.getCapital());

        return dto;
    }
}
