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

    private String name;
    private String email;
    private String hashPassword;

    private String googleName;
    private String googleUsername;

    private LocalDateTime createdAt;


    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Pet> petSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getGoogleName() {
        return googleName;
    }

    public void setGoogleName(String googleName) {
        this.googleName = googleName;
    }

    public String getGoogleUsername() {
        return googleUsername;
    }

    public void setGoogleUsername(String googleUsername) {
        this.googleUsername = googleUsername;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Pet> getPetSet() {
        return petSet;
    }

    public void setPetSet(Set<Pet> petSet) {
        this.petSet = petSet;
    }
}
