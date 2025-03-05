package ru.tagirov.TheMedicalSystem.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tagirov.TheMedicalSystem.Models.Person;
import ru.tagirov.TheMedicalSystem.Repositories.PersonRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService{
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }
}
