package ru.itis.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springbootdemo.models.Owner;
import ru.itis.springbootdemo.models.Shelter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OwnerDto {

    private int id;

    private String name;

    private String address;

    private String description;


    public static OwnerDto from(Owner owner) {
        return OwnerDto.builder()
                .name(owner.getName())
                .address(owner.getAddress())
                .id(owner.getIdOwner())
                .description(owner.getDescription())
                .build();
    }


    public static List<OwnerDto> from(List<Owner> owners) {
        return owners.stream()
                .map(OwnerDto::from)
                .collect(Collectors.toList());
    }
}
