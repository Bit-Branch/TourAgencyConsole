package by.bsuir.java.service.impl;


import by.bsuir.java.dao.SaleDAO;
import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.dao.factory.DAOFactory;

import by.bsuir.java.entity.Country;
import by.bsuir.java.entity.Sale;
import by.bsuir.java.service.SaleService;
import by.bsuir.java.service.exception.ServiceException;
import by.bsuir.java.service.validator.ServiceValidator;

import java.util.List;

public class SaleServiceImpl implements SaleService, ServiceValidator {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private SaleDAO saleDAO = daoFactory.getSaleDAO();

    @Override
    public List<Sale> getAllByClientId(Integer idAccount) throws ServiceException {
        try{
            return saleDAO.getAllByClientId(idAccount);
        }catch (DAOException ex){
            String error = "Can not get all records in ExpenseServiceImpl: " + ex.getMessage();
            throw new ServiceException(error);
        }
    }

    @Override
    public List<Sale> getAllByEmployeeId(Integer idAccount) throws ServiceException {
        try{
            return saleDAO.getAllByEmployeeId(idAccount);
        }catch (DAOException ex){
            String error = "Can not get all records in ExpenseServiceImpl: " + ex.getMessage();
            throw new ServiceException(error);
        }
    }

    @Override
    public List<Sale> getAllByTourId(Integer idAccount) throws ServiceException {
        try{
            return saleDAO.getAllByTourId(idAccount);
        }catch (DAOException ex){
            String error = "Can not get all records in ExpenseServiceImpl: " + ex.getMessage();
            throw new ServiceException(error);
        }
    }

    @Override
    public List<Sale> getAll() throws ServiceException {
        try{
            return saleDAO.getAll();
        }catch (DAOException ex){
            String error = "Can not get all records in ExpenseServiceImpl: " + ex.getMessage();
            throw new ServiceException(error);
        }
    }

    @Override
    public Sale getById(Integer id) throws ServiceException {
        String error= "Unable to get expense by id : ";
        if (isNull(id)){
            throw new ServiceException(error + "id has null value");
        }
        try{
            return saleDAO.getById(id);
        }catch (DAOException ex){
            throw new ServiceException(error + ex.getMessage());
        }
    }

    @Override
    public Long create(Sale obj) throws ServiceException {
        String error= "Unable to add expense: ";
        if (isNull(obj)){
            throw new ServiceException(error + "expense has null value");
        }
        try{
            Integer id = getAll().size();
            obj.setId(id);
            SaleService clientService = new SaleServiceImpl();
            Sale client = clientService.getById((int)obj.getId());
            if (client == null){
                client = new Sale();
                client.setId(obj.getId());
            }
            client.setSaleTime(obj.getSaleTime());
            client.setCount(obj.getCount());
            client.setClientID(obj.getClientID());
            client.setEmployeeID(obj.getEmployeeID());
            client.setTourID(obj.getTourID());
            clientService.update(client);
            return saleDAO.add(obj);
        }catch (DAOException ex){
            throw new ServiceException(error + ex.getMessage());
        }
    }

    @Override
    public void update(Sale obj) throws ServiceException {
        String error= "Unable to update expense: ";
        if (isNull(obj)){
            throw new ServiceException(error + "object has null value");
        }
        try{
            saleDAO.update(obj);
        }catch (DAOException ex){
            throw new ServiceException(error + ex.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws ServiceException {
        String error= "Unable to delete expense: ";
        if (isNull(id)){
            throw new ServiceException(error + "object has null value");
        }
        try{
            saleDAO.delete(id);
        }catch (DAOException ex){
            throw new ServiceException();
        }
    }
}
