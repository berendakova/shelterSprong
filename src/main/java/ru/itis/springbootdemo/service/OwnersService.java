package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.OwnerDto;
import ru.itis.springbootdemo.dto.PetDto;

import java.util.List;

public interface OwnersService {
    List<OwnerDto> getAllOwners();
    OwnerDto getOwnerById(Integer ownerId);

}
