package by.bsuir.java.service.impl;

import by.bsuir.java.dao.AccountDAO;
import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.dao.factory.DAOFactory;
import by.bsuir.java.entity.Account;
import by.bsuir.java.service.AccountService;
import by.bsuir.java.service.exception.ServiceException;


import java.util.List;

public class AccountServiceImpl implements AccountService {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private AccountDAO accountDAO = daoFactory.getAccountDAO();

    @Override
    public Account signIn(String login, String password) throws ServiceException {
        if (login == null || login.isEmpty()){
            throw new ServiceException("invalid login");
        }
        if (password == null || password.isEmpty()){
            throw new ServiceException("invalid password");
        }
        try{
            return accountDAO.signIn(login,password);
        }catch (DAOException ex){
            throw new ServiceException();
        }
    }


    @Override
    public void register(Account user) throws ServiceException {
        if (user == null){
            throw new ServiceException("invalid password");
        }
        try{
            Integer id = getAll().size();
            user.setId(id);
            accountDAO.register(user);
        }catch (DAOException ex){
            throw new ServiceException();
        }
    }

    @Override
    public List<Account> getAll() throws ServiceException {
        try{
            return accountDAO.getAll();
        }catch (DAOException ex){
            throw new ServiceException();
        }
    }

    @Override
    public Account getById(Integer id) throws ServiceException {
        try{
            return accountDAO.getById(id);
        }catch (DAOException ex){
            throw new ServiceException();
        }
    }

    @Override
    public Long create(Account obj) throws ServiceException {
        try{
            Integer id = getAll().size();
            obj.setId(id);
            return accountDAO.add(obj);
        }catch (DAOException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void update(Account obj) throws ServiceException {
        try{
            accountDAO.update(obj);
        }catch (DAOException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void delete(Integer id) throws ServiceException {
        try{
            accountDAO.delete(id);
        }catch (DAOException ex){
            throw new ServiceException();
        }
    }
}
