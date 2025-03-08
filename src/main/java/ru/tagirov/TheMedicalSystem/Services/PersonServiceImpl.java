package ru.tagirov.TheMedicalSystem.Services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tagirov.TheMedicalSystem.Models.*;
import ru.tagirov.TheMedicalSystem.Repositories.*;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @Transactional
    @Override
    public void savePerson(Person person) {
        System.out.println("Сохраняем Person: " + person.getId());
        personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }
}
