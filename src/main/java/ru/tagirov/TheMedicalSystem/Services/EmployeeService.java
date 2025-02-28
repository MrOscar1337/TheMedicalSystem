package ru.tagirov.TheMedicalSystem.Services;

import ru.tagirov.TheMedicalSystem.Models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployees();
    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
}
