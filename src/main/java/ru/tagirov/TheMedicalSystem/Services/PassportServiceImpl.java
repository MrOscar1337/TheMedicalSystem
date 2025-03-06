package ru.tagirov.TheMedicalSystem.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tagirov.TheMedicalSystem.Models.Passport;
import ru.tagirov.TheMedicalSystem.Repositories.PassportRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class PassportServiceImpl implements PassportService{
    @Autowired
    PassportRepository passportRepository;

    @Override
    public List<Passport> findAllPassports() {
        return passportRepository.findAll();
    }

    @Override
    public Passport savePassport(Passport passport) {
        return passportRepository.save(passport);
    }

    @Override
    public Passport updatePassport(Passport passport) {
        return passportRepository.save(passport);
    }
}
