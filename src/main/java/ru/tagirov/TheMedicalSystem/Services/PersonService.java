package ru.tagirov.TheMedicalSystem.Services;

import ru.tagirov.TheMedicalSystem.Models.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAllPersons();
    Person savePerson(Person person);
    Person updatePerson(Person person);
}
