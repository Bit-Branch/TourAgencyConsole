package by.bsuir.java.dao.impl;

import by.bsuir.java.dao.EmployeeDAO;

import by.bsuir.java.dao.converter.impl.EmployeeConverter;
import by.bsuir.java.dao.datasource.DataSource;
import by.bsuir.java.dao.datasource.exception.DataSourceException;
import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.dao.validator.DAOValidator;
import by.bsuir.java.entity.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileEmployeeDAO implements EmployeeDAO, DAOValidator {

	private DataSource<Employee> dataSource;
	private EmployeeConverter employeeConverter;

	public FileEmployeeDAO() {
		dataSource = new DataSource<>("/Employees.txt");
		employeeConverter = new EmployeeConverter();
	}

	public FileEmployeeDAO(DataSource<Employee> dataSource, EmployeeConverter accountConverter) {
		this.dataSource = dataSource;
		this.employeeConverter = accountConverter;
	}

	public DataSource<Employee> getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource<Employee> dataSource) {
		this.dataSource = dataSource;
	}

	public EmployeeConverter getEmployeeConverter() {
		return employeeConverter;
	}

	public void setEmployeeConverter(EmployeeConverter employeeConverter) {
		this.employeeConverter = employeeConverter;
	}


	@Override
	public List<Employee> getAll() throws DAOException {
		List<Employee> users;
		try {
			users = dataSource.read(employeeConverter);
		} catch (DataSourceException e) {
			String error = "Can not get all records in FileUserDAO: " + e.getMessage();
			throw new DAOException(error, e);
		}
		return users;
	}

	@Override
	public Employee getById(Integer id) throws DAOException {
		String error = "Unable to get user by id : ";
		if (isNull(id)) {
			throw new DAOException(error + "id has null value");
		}
		Employee profile = null;
		List<Employee> users = getAll();
		for (Employee user : users
		) {
			if (user.getId() == id) {
				profile = user;
				break;
			}
		}
		return profile;
	}

	@Override
	public Long add(Employee object) throws DAOException {
		String error = "Unable to add user: ";
		if (isNull(object)) {
			throw new DAOException(error + "user has null value");
		}
		try {
			dataSource.write(object, true, employeeConverter);
		} catch (DataSourceException e) {
			throw new DAOException(error + e.getMessage(), e);
		}
		return object.getId();
	}

	@Override
	public void update(Employee object) throws DAOException {
		String error = "Unable to update user: ";
		if (isNull(object)) {
			throw new DAOException(error + "object has null value");
		}
		List<Employee> users = getAll();
		Iterator<Employee> userIterator = users.iterator();
		while (userIterator.hasNext()) {
			Employee nextUser = userIterator.next();
			if (nextUser.getId() == object.getId()) {
				nextUser.setSurname(object.getSurname());
				nextUser.setName(object.getName());
				nextUser.setPatronymic(object.getPatronymic());
				nextUser.setPhone(object.getPhone());
				nextUser.setAccountID(object.getAccountID());
			}
		}
		try {
			dataSource.write(users, employeeConverter);
		} catch (DataSourceException e) {
			throw new DAOException(error + e.getMessage(), e);
		}
	}

	@Override
	public void delete(Integer id) throws DAOException {
		String error = "Unable to delete user: ";
		if (isNull(id)) {
			throw new DAOException(error + "object has null value");
		}
		List<Employee> users = getAll();
		Iterator<Employee> userIterator = users.iterator();
		while (userIterator.hasNext()) {
			Employee nextUser = userIterator.next();
			if (nextUser.getId() == id) {
				userIterator.remove();
			}
		}
		try {
			dataSource.write(users, employeeConverter);
		} catch (DataSourceException e) {
			throw new DAOException(error + e.getMessage(), e);
		}
	}

	@Override
	public List<Employee> getAllByAccountId(Integer idAccount) throws DAOException {
		String error = "Unable to get clients by id: ";
		if (isNull(idAccount)) {
			throw new DAOException(error + "idAccount has null value");
		}
		List<Employee> dataSourceExpenseList;
		List<Employee> expenseList = new ArrayList<>();
		try {
			dataSourceExpenseList = dataSource.read(employeeConverter);
			for (Employee expense : dataSourceExpenseList
			) {
				if (idAccount == expense.getAccountID()) {
					expenseList.add(expense);
				}
			}
		} catch (DataSourceException e) {
			throw new DAOException(error + e.getMessage(), e);
		}
		return expenseList;
	}
}