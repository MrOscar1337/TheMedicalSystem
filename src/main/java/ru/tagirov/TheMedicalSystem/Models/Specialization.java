package ru.tagirov.TheMedicalSystem.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "specializations")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialization_id")
    private int id;
    @Column(name = "specialization_name")
    private String specialization_name;
}
