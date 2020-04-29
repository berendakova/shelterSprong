package ru.itis.springbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Data
@DynamicUpdate
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Entity
    @Table(name = "shelter")
    public class Shelter {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;
        private String address;
        private String description;

    @ManyToMany(mappedBy = "shelters")
    private List<Owner> owners;


    public void addOwner(Owner owner) {
        owners.add(owner);
        owner.getShelters().add(this);
    }

    public void removeOwner(Owner owner) {
        owners.remove(owner);
        owner.getShelters().remove(this);
    }
    }


