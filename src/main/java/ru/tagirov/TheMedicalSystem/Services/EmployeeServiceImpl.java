package ru.tagirov.TheMedicalSystem.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tagirov.TheMedicalSystem.Models.Employee;
import ru.tagirov.TheMedicalSystem.Repositories.EmployeeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
