package ru.tagirov.TheMedicalSystem.Models;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class UserDto {
    private int id;
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

    public @NotBlank(message = "Name is mandatory") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is mandatory") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Surname is mandatory") String getSurname() {
        return surname;
    }

    public void setSurname(@NotBlank(message = "Surname is mandatory") String surname) {
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

    public @NotBlank(message = "Gender is mandatory") String getGender() {
        return gender;
    }

    public void setGender(@NotBlank(message = "Gender is mandatory") String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank(message = "Email is mandatory") @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is mandatory") @Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Password is mandatory") @Size(min = 6, message = "Password must be at least 6 characters long") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is mandatory") @Size(min = 6, message = "Password must be at least 6 characters long") String password) {
        this.password = password;
    }
}
