package by.bsuir.java.dao;

import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.entity.Hotel;
import by.bsuir.java.entity.Return;

import java.util.List;

public interface ReturnDAO extends DAO<Return> {
    List<Return> getAllByClientId(Integer idClient) throws DAOException;
    List<Return> getAllByEmployeeId(Integer idEmployee) throws DAOException;
    List<Return> getAllByTourId(Integer idTour) throws DAOException;
}
