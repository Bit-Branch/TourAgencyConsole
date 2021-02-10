package by.bsuir.java.dao;

import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.entity.Return;
import by.bsuir.java.entity.Sale;

import java.util.List;

public interface SaleDAO extends DAO<Sale> {
    List<Sale> getAllByClientId(Integer idClient) throws DAOException;
    List<Sale> getAllByEmployeeId(Integer idEmployee) throws DAOException;
    List<Sale> getAllByTourId(Integer idTour) throws DAOException;
}
