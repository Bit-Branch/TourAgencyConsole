package by.bsuir.java.dao;

import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.entity.Employee;

import java.util.List;

public interface EmployeeDAO extends DAO<Employee>{
	List<Employee> getAllByAccountId(Integer idAccount) throws DAOException;
}
