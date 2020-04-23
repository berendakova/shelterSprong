package ru.itis.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springbootdemo.models.Pet;
import ru.itis.springbootdemo.models.Shelter;
import ru.itis.springbootdemo.models.StatusPet;
import ru.itis.springbootdemo.models.User;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ShelterDto {
    private int id;

    private String name;

    private String address;

    private String description;


    public static ShelterDto from(Shelter shelter) {
        return ShelterDto.builder()
                .name(shelter.getName())
                .address(shelter.getAddress())
                .id(shelter.getId())
                .description(shelter.getDescription())
                .build();
    }


    public static List<ShelterDto> from(List<Shelter> shelters) {
        return shelters.stream()
                .map(ShelterDto::from)
                .collect(Collectors.toList());
    }
}
