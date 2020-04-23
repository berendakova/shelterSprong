package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.PetDto;
import ru.itis.springbootdemo.dto.ShelterDto;

import java.util.List;

public interface ShelterService {
    List<ShelterDto> getAllShelter();

    void deleteShelter(Integer shelterId);
}
