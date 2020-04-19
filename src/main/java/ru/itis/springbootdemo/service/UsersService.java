package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();

    void deleteUser(Long userId);
}
