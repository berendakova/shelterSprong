package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.Owner;
import ru.itis.springbootdemo.models.Pet;
import ru.itis.springbootdemo.models.Shelter;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Set;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    Owner findOwnerByIdOwner(Integer idOwner);
}
