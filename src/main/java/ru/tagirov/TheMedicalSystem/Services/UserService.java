package ru.tagirov.TheMedicalSystem.Services;

import ru.tagirov.TheMedicalSystem.Models.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User findUserByEmail(String email);
    void saveUser(User user);
}
