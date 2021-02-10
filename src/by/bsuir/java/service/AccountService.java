package by.bsuir.java.service;

import by.bsuir.java.entity.Account;
import by.bsuir.java.service.exception.ServiceException;


public interface AccountService extends Service<Account> {
    Account signIn(String login, String password) throws ServiceException;
    void register(Account user) throws ServiceException;
}
