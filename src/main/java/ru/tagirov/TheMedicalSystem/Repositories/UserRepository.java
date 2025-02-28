package ru.tagirov.TheMedicalSystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tagirov.TheMedicalSystem.Models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
