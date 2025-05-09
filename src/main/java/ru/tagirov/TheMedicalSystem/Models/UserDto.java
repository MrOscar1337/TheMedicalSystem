package ru.tagirov.TheMedicalSystem.Models;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
public class UserDto {
    private int id;
    @Email(message = "Email should be valid")
    private String email;

    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;
    private String name;
    private String surname;
    private String patronymic;

    @NotNull(message = "Birth is mandatory")
    @PastOrPresent(message = "Date must be in the past or present")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birth;
    private String gender;
    private String passportSeries;
    private String passportNumber;
    @NotNull(message = "Passport issue date is mandatory")
    @PastOrPresent(message = "Passport issue date must be in the past or present")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate passportIssue;
    private String region;
    private String city;
    private String street;
    private String house;
    private int flat;
    private boolean fact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    public @Size(min = 6, message = "Password must be at least 6 characters long") String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 6, message = "Password must be at least 6 characters long") String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public @NotNull(message = "Birth is mandatory") @PastOrPresent(message = "Date must be in the past or present") LocalDate getBirth() {
        return birth;
    }

    public void setBirth(@NotNull(message = "Birth is mandatory") @PastOrPresent(message = "Date must be in the past or present") LocalDate birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public @NotNull(message = "Passport issue date is mandatory") @PastOrPresent(message = "Passport issue date must be in the past or present") LocalDate getPassportIssue() {
        return passportIssue;
    }

    public void setPassportIssue(@NotNull(message = "Passport issue date is mandatory") @PastOrPresent(message = "Passport issue date must be in the past or present") LocalDate passportIssue) {
        this.passportIssue = passportIssue;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public boolean isFact() {
        return fact;
    }

    public void setFact(boolean fact) {
        this.fact = fact;
    }
}
