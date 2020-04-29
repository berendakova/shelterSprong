package ru.itis.springbootdemo.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicUpdate
@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOwner;

    private String name;

    private String address;

    private String description;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "owner_shelter",
            joinColumns = {@JoinColumn(name = "owner_id")},
            inverseJoinColumns = {@JoinColumn(name = "shelter_id")}
    )
    private List<Shelter> shelters;

    public void addShelter(Shelter shelter) {
        shelters.add(shelter);
        shelter.getOwners().add(this);
    }

    public void removeShelter(Shelter shelter) {
        shelters.remove(shelter);
        shelter.getOwners().remove(this);
    }
}