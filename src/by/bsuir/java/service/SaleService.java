package by.bsuir.java.service;

import by.bsuir.java.entity.Return;
import by.bsuir.java.entity.Sale;
import by.bsuir.java.service.exception.ServiceException;

import java.util.List;

public interface SaleService extends Service<Sale> {
    List<Sale> getAllByClientId(Integer idClient) throws ServiceException;
    List<Sale> getAllByEmployeeId(Integer idEmployee) throws ServiceException;
    List<Sale> getAllByTourId(Integer idTour) throws ServiceException;
}
