package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.CreatedPetDto;
import ru.itis.springbootdemo.dto.PetDto;
import ru.itis.springbootdemo.dto.SignUpDto;
import ru.itis.springbootdemo.exceptions.NotCorrectSamePassword;
import ru.itis.springbootdemo.models.Pet;
import ru.itis.springbootdemo.models.Role;
import ru.itis.springbootdemo.models.StatusPet;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.PetsRepository;

import java.time.LocalDateTime;
@Component
public class CreatePetServiceImpl implements CreatePetService {

    @Autowired
    PetsRepository petsRepository;
    @Override
    public void created(CreatedPetDto form) {
        Pet pet = Pet.builder()
                .name(form.getName())
                .age(form.getAge())
                .description(form.getDescription())
                .disease(form.getDisease())
                .img(form.getImg())
                .breed(form.getBreed())
                .sex(form.getSex())
                .status(StatusPet.SHELTER)
                .build();
        petsRepository.save(pet);
    }
}
