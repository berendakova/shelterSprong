package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.PetDto;
import ru.itis.springbootdemo.repositories.PetsRepository;

import java.util.List;
@Component
public class PetsServiceImpl implements PetsService {
    @Autowired
    private PetsRepository petsRepository;

    @Override
    public List<PetDto> getAllPets() {
       return PetDto.from(petsRepository.findAll());
    }

    @Override
    public PetDto getPetById(Integer petId) {
        return  PetDto.from(petsRepository.findPetById(petId));
    }

    @Override
    public void deletePet(Integer petId) {
        petsRepository.deleteById(petId);
    }



}
