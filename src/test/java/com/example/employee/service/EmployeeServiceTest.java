package com.example.employee.service;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    @Test
    void shouldGetAllEmployees() {
        List<Employee> employees = List.of(
                new Employee(1L, "John", "IT", 50000.0),
                new Employee(2L, "Mike", "HR", 45000.0)
        );

        when(repository.findAll()).thenReturn(employees);

        List<Employee> result = service.getAllEmployees();

        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getName());
    }
}
