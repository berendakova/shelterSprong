package ru.itis.springbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springbootdemo.utils.FieldMatch;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "itis_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "userId")
    private Long id;
    @NotBlank(message = "username can't empty!")
    private String name;
    @NotBlank(message = "email can't empty!")
    private String email;
    @NotBlank(message = "password can't empty!")
    private String hashPassword;

    private LocalDateTime createdAt;


    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Pet> petSet = new HashSet<>();
}
