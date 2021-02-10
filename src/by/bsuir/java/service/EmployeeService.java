package by.bsuir.java.service;

import by.bsuir.java.entity.Employee;
import by.bsuir.java.service.exception.ServiceException;

import java.util.List;

public interface EmployeeService extends Service<Employee> {
    List<Employee> getAll(Integer idAccount) throws ServiceException;
}
