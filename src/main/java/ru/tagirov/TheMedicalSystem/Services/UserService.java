package ru.tagirov.TheMedicalSystem.Services;

import ru.tagirov.TheMedicalSystem.Models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();
    Optional<User> findByEmail(String email);
    void saveUser(User user);
    boolean existsByEmail(String email);
}
