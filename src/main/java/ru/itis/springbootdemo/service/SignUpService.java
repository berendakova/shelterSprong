package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.SignUpDto;
import ru.itis.springbootdemo.exceptions.NotCorrectSamePassword;

public interface SignUpService {
    void signUp(SignUpDto form) throws NotCorrectSamePassword;
}
