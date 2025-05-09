package ru.tagirov.TheMedicalSystem.Models;

import java.time.LocalDate;
import java.util.Date;
import jakarta.persistence.*;


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
    private LocalDate issue;

    @OneToOne(mappedBy = "passport", orphanRemoval = true)
    private Person owner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getIssue() {
        return issue;
    }

    public void setIssue(LocalDate issue) {
        this.issue = issue;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
