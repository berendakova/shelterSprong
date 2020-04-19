package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.PetDto;


import java.util.List;

public interface PetsService {
    List<PetDto> getAllPets();

    void deletePet(Integer petId);
}
