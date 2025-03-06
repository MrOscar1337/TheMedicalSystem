package ru.tagirov.TheMedicalSystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tagirov.TheMedicalSystem.Models.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
