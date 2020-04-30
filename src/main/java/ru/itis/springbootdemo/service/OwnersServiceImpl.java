package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.OwnerDto;
import ru.itis.springbootdemo.dto.PetDto;
import ru.itis.springbootdemo.dto.ShelterDto;
import ru.itis.springbootdemo.repositories.OwnerRepository;

import java.util.List;
@Component
public class OwnersServiceImpl implements OwnersService {
    @Autowired
    OwnerRepository ownerRepository;
    @Override
    public List<OwnerDto> getAllOwners() {
        return OwnerDto.from(ownerRepository.findAll());
    }

    @Override
    public OwnerDto getOwnerById(Integer ownerId) {
        return  OwnerDto.from(ownerRepository.findOwnerByIdOwner(ownerId));

    }
}
