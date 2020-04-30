package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.SignUpDto;

import ru.itis.springbootdemo.models.Role;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;

import java.time.LocalDateTime;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpDto form)  {
        if (form.getPassword().equals(form.getRepeatedPassword())) {
            User user = User.builder()
                    .email(form.getEmail())
                    .hashPassword(passwordEncoder.encode(form.getPassword()))
                    .name(form.getName())
                    .role(Role.USER)
                    .createdAt(LocalDateTime.now())
                    .build();
            usersRepository.save(user);
        }

    }
}
