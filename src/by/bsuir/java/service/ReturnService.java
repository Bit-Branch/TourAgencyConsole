package by.bsuir.java.service;

import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.entity.Return;
import by.bsuir.java.service.exception.ServiceException;

import java.util.List;

public interface ReturnService extends Service<Return> {
    List<Return> getAllByClientId(Integer idClient) throws ServiceException;
    List<Return> getAllByEmployeeId(Integer idEmployee) throws ServiceException;
    List<Return> getAllByTourId(Integer idTour) throws ServiceException;
}
