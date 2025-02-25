package ru.tagirov.TheMedicalSystem.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int id;
    @Column(name = "region")
    private String region;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "house")
    private String house;
    @Column(name = "flat")
    private int flat;
    @Column(name = "fact")
    private boolean fact;

    @OneToOne (optional=false, mappedBy="address")
    private Person owner;
}
