package ru.tagirov.TheMedicalSystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tagirov.TheMedicalSystem.Models.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
