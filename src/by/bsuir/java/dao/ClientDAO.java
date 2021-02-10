package by.bsuir.java.dao;

import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.entity.Client;

import java.util.List;

public interface ClientDAO extends DAO<Client>{
    List<Client> getAllByAccountId(Integer idAccount) throws DAOException;
}
