package by.bsuir.java.dao;




import by.bsuir.java.dao.exception.DAOException;

import java.util.List;

public interface DAO<T>{
    List<T> getAll() throws DAOException;

    T getById(Integer id) throws DAOException;

    Long add(T object) throws DAOException;

    void update(T object) throws DAOException;

    void delete(Integer id) throws DAOException;
}
