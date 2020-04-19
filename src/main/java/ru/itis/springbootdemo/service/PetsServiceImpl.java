package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.PetDto;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.repositories.PetsRepository;
import ru.itis.springbootdemo.repositories.UsersRepository;

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
    public void deletePet(Integer petId) {
        petsRepository.deleteById(petId);
    }



}
