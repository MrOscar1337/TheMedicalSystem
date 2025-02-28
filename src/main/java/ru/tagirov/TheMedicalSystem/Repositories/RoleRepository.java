package ru.tagirov.TheMedicalSystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tagirov.TheMedicalSystem.Models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
