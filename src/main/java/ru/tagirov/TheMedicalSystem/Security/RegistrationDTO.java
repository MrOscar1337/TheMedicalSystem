package ru.tagirov.TheMedicalSystem.Security;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;


public class RegistrationDTO {
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Surname is mandatory")
    private String surname;

    private String patronymic;

    @NotNull(message = "Birth is mandatory")
    @PastOrPresent(message = "Date must be in the past or present")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birth;

    @NotBlank(message = "Gender is mandatory")
    private String gender;

    @NotBlank(message = "Series is mandatory")
    private String passportSeries;

    @NotBlank(message = "Number is mandatory")
    private String passportNumber;

    @NotNull(message = "Passport issue date is mandatory")
    @PastOrPresent(message = "Passport issue date must be in the past or present")
    private Date passportIssue;

    @NotBlank(message = "Region is mandatory")
    private String region;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "Street is mandatory")
    private String street;

    @NotBlank(message = "House is mandatory")
    private String house;

    private int flat;
    private boolean fact;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
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

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
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

    public Date getPassportIssue() {
        return passportIssue;
    }

    public void setPassportIssue(Date passportIssue) {
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