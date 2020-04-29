package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.Pet;
import ru.itis.springbootdemo.models.Shelter;

import java.util.List;
import java.util.Optional;

public interface ShelterRepository extends JpaRepository<Shelter, Integer> {
    Optional<Shelter> findShelterByName(String name);

}
