package ru.tagirov.TheMedicalSystem.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
@Table(name = "privileges")
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "privilege_id")
    private int id;
    @Column(name = "privilege_name")
    private String privilege_name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
}
