package ru.tagirov.TheMedicalSystem.Models;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "birth")
    private Date birth;
    @Column(name = "gender")
    private String gender;

    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne (optional=false, mappedBy="person")
    private Patient patientOwner;

    @OneToOne (optional=false, mappedBy="person")
    private Employee employeeOwner;
}
