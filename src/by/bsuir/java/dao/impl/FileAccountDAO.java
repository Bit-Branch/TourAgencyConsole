package by.bsuir.java.dao.impl;



import by.bsuir.java.dao.AccountDAO;
import by.bsuir.java.dao.converter.Converter;
import by.bsuir.java.dao.converter.impl.AccountConverter;
import by.bsuir.java.dao.datasource.DataSource;
import by.bsuir.java.dao.datasource.exception.DataSourceException;
import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.dao.validator.DAOValidator;
import by.bsuir.java.entity.Account;

import java.util.Iterator;
import java.util.List;


public class FileAccountDAO implements AccountDAO, DAOValidator {

	private DataSource<Account> dataSource;
	private AccountConverter accountConverter;

	public FileAccountDAO(){
		dataSource= new DataSource<>("/Accounts.txt");
		accountConverter = new AccountConverter();
	}

	public FileAccountDAO(DataSource<Account> dataSource, AccountConverter accountConverter){
		this.dataSource = dataSource;
		this.accountConverter = accountConverter;
	}

	public DataSource<Account> getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource<Account> dataSource) {
		this.dataSource = dataSource;
	}

	public AccountConverter getAccountConverter() {
		return accountConverter;
	}

	public void setAccountConverter(AccountConverter accountConverter) {
		this.accountConverter = accountConverter;
	}

	@Override
	public Account signIn(String login, String password) throws DAOException {
		Account existingUser = null;
		List<Account> users = getAll();
		for (Account user : users
		) {
			if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
				existingUser = user;
				break;
			}
		}
		return existingUser;
	}


	@Override
	public void register(Account user) throws DAOException {
			if (!isLoginReserved(user.getLogin())) {
				add(user);
			}
	}

	@Override
	public boolean isLoginReserved(String login) throws DAOException {
		boolean isReserved = false;
		List<Account> users = getAll();
		for (Account user : users
		) {
			if (user.getLogin().equals(login)) {
				isReserved = true;
				break;
			}
		}
		return isReserved;
	}

	@Override
	public List<Account> getAll() throws DAOException {
		List<Account> users;
		try {
			users = dataSource.read(accountConverter);
		} catch (DataSourceException e) {
			String error = "Can not get all records in FileUserDAO: " + e.getMessage();
			throw new DAOException(error, e);
		}
		return users;
	}

	@Override
	public Account getById(Integer id) throws DAOException {
		String error= "Unable to get user by id : ";
		if (isNull(id)){
			throw new DAOException(error + "id has null value");
		}
		Account profile = null;
		List<Account> users = getAll();
		for (Account user : users
		) {
			if (user.getId() == id) {
				profile = user;
				break;
			}
		}
		return profile;
	}

	@Override
	public Long add(Account object) throws DAOException {
		String error= "Unable to add user: ";
		if (isNull(object)){
			throw new DAOException(error + "user has null value");
		}
		try {
				dataSource.write(object, true, accountConverter);
		} catch (DataSourceException e) {
			throw new DAOException(error + e.getMessage(), e);
		}
		return object.getId();
	}

	@Override
	public void update(Account object) throws DAOException {
		String error= "Unable to update user: ";
		if (isNull(object)){
			throw new DAOException(error + "object has null value");
		}
		List<Account> users = getAll();
		Iterator<Account> userIterator = users.iterator();
		while(userIterator.hasNext()) {
			Account nextUser = userIterator.next();
			if (nextUser.getId() == object.getId()) {
				nextUser.setRole(object.getRole());
				nextUser.setLogin(object.getLogin());
				nextUser.setPassword(object.getPassword());
			}
		}
		try {
			dataSource.write(users, accountConverter);
		} catch (DataSourceException e) {
			throw new DAOException(error + e.getMessage(), e);
		}
	}

	@Override
	public void delete(Integer id) throws DAOException {
		String error= "Unable to delete user: ";
		if (isNull(id)){
			throw new DAOException(error + "object has null value");
		}
		List<Account> users = getAll();
		Iterator<Account> userIterator = users.iterator();
		while(userIterator.hasNext()) {

			Account nextUser = userIterator.next();
			if (nextUser.getId() == id) {
				userIterator.remove();
			}
		}
		try {
			dataSource.write(users, accountConverter);
		} catch (DataSourceException e) {
			throw new DAOException(error + e.getMessage(), e);
		}
	}
}