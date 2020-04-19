package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.Pet;
import ru.itis.springbootdemo.models.User;

import java.util.Optional;

public interface PetsRepository extends JpaRepository<Pet, Integer> {
    Optional<Pet> findPetByName(String name);

}