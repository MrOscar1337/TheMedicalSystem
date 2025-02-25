package ru.tagirov.TheMedicalSystem.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private int id;
    @Column(name = "record_name")
    private String record_name;
    @Column(name = "record_description")
    private String record_description;
}
