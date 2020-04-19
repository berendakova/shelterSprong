package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.CreatedPetDto;
import ru.itis.springbootdemo.dto.PetDto;


public interface CreatePetService {
    void created(CreatedPetDto form);
}
