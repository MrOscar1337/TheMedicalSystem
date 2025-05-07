package ru.tagirov.TheMedicalSystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tagirov.TheMedicalSystem.Models.Passport;

public interface PassportRepository extends JpaRepository<Passport, Integer> {
}
