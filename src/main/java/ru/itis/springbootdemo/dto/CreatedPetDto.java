package ru.itis.springbootdemo.dto;

import lombok.Data;

@Data
public class CreatedPetDto {

    private String name;
    private String age;
    private String img;
    private String description;
    private String sex;
    private String breed;
    private String disease;
}
