package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.springbootdemo.dto.PetDto;
import ru.itis.springbootdemo.dto.ShelterDto;
import ru.itis.springbootdemo.repositories.ShelterRepository;

import java.util.List;

public class ShelterServiceImpl implements ShelterService{
    @Autowired
    ShelterRepository shelterRepository;
    @Override
    public List<ShelterDto> getAllShelter() {
        return ShelterDto.from(shelterRepository.findAll());
    }

    @Override
    public void deleteShelter(Integer shelterId) {
        shelterRepository.deleteById(shelterId);
    }

}
