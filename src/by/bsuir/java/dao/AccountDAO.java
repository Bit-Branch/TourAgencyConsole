package by.bsuir.java.dao;

import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.entity.Account;

public interface AccountDAO extends DAO<Account> {

	Account signIn(String login, String password) throws DAOException;
	void register(Account user) throws DAOException;
	boolean isLoginReserved(String login) throws DAOException;
}
