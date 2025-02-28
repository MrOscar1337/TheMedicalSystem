package ru.tagirov.TheMedicalSystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tagirov.TheMedicalSystem.Models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
