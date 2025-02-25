package ru.tagirov.TheMedicalSystem.Models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private int id;
    @Column(name = "service_name")
    private String service_name;
    @Column(name = "service_time")
    private Date service_time;

    @OneToMany
    @JoinColumn(name = "record_id")
    private List<Record> records;

    @Column(name = "service_price")
    private int service_price;
}
