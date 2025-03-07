package ru.tagirov.TheMedicalSystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tagirov.TheMedicalSystem.Models.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
