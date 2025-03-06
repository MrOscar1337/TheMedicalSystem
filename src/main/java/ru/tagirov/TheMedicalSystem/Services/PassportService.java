package ru.tagirov.TheMedicalSystem.Services;

import ru.tagirov.TheMedicalSystem.Models.Passport;

import java.util.List;

public interface PassportService {
    List<Passport> findAllPassports();
    Passport savePassport(Passport passport);
    Passport updatePassport(Passport passport);
}
