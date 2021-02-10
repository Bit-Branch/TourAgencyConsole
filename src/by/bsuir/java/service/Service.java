package by.bsuir.java.service;



import by.bsuir.java.service.exception.ServiceException;

import java.util.List;

public interface Service<T> {
    List<T> getAll() throws ServiceException;
    T getById(Integer id) throws ServiceException;
    Long create(T obj) throws ServiceException;
    void update(T obj) throws ServiceException;
    void delete(Integer id) throws ServiceException;
}
