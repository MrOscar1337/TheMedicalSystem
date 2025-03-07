package ru.tagirov.TheMedicalSystem.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tagirov.TheMedicalSystem.Models.*;
import ru.tagirov.TheMedicalSystem.Repositories.*;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private final PersonRepository personRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PassportRepository passportRepository;
    @Autowired
    private final AddressRepository addressRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, UserRepository userRepository, PassportRepository passportRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.userRepository = userRepository;
        this.passportRepository = passportRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);


    }

    @Override
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }
}
