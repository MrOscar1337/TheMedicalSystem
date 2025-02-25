package ru.tagirov.TheMedicalSystem.Models;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "passports")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id")
    private int id;
    @Column(name = "series")
    private String series;
    @Column(name = "number")
    private String number;
    @Column(name = "date_issue")
    private Date issue;

    @OneToOne (optional=false, mappedBy="passport")
    private Person owner;
}
