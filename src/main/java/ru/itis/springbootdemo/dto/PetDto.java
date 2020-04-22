package ru.itis.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springbootdemo.models.Pet;
import ru.itis.springbootdemo.models.StatusPet;
import ru.itis.springbootdemo.models.User;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PetDto {
    private int id;

    private String name;

    private String age;
    private String img;
    private String description;
    private String sex;
    private String breed;
    private String disease;
    private StatusPet status;
    public static PetDto from(Pet pet) {
        return PetDto.builder()
                .name(pet.getName())
                .age(pet.getAge())
                .id(pet.getId())
                .breed(pet.getBreed())
                .description(pet.getDescription())
                .disease(pet.getDisease())
                .sex(pet.getSex())
                .img(pet.getSex())
                .status(pet.getStatus())
                .build();
    }

    public static List<PetDto> from(List<Pet> pets) {
        return pets.stream()
                .map(PetDto::from)
                .collect(Collectors.toList());
    }
}
