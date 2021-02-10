package by.bsuir.java.service.impl;

import by.bsuir.java.dao.ReturnDAO;
import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.dao.factory.DAOFactory;
import by.bsuir.java.entity.Country;
import by.bsuir.java.entity.Return;
import by.bsuir.java.service.ReturnService;
import by.bsuir.java.service.exception.ServiceException;
import by.bsuir.java.service.validator.ServiceValidator;

import java.util.List;

public class ReturnServiceImpl implements ReturnService, ServiceValidator {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private ReturnDAO returnDAO = daoFactory.getReturnDAO();

    @Override
    public List<Return> getAllByClientId(Integer idClient) throws ServiceException {
        try{
            return returnDAO.getAllByClientId(idClient);
        }catch (DAOException ex){
            String error = "Can not get all records in ExpenseServiceImpl: " + ex.getMessage();
            throw new ServiceException(error);
        }
    }

    @Override
    public List<Return> getAllByEmployeeId(Integer idAccount) throws ServiceException {
        try{
            return returnDAO.getAllByEmployeeId(idAccount);
        }catch (DAOException ex){
            String error = "Can not get all records in ExpenseServiceImpl: " + ex.getMessage();
            throw new ServiceException(error);
        }
    }

    @Override
    public List<Return> getAllByTourId(Integer idAccount) throws ServiceException {
        try{
            return returnDAO.getAllByTourId(idAccount);
        }catch (DAOException ex){
            String error = "Can not get all records in ExpenseServiceImpl: " + ex.getMessage();
            throw new ServiceException(error);
        }
    }

    @Override
    public List<Return> getAll() throws ServiceException {
        try{
            return returnDAO.getAll();
        }catch (DAOException ex){
            String error = "Can not get all records in ExpenseServiceImpl: " + ex.getMessage();
            throw new ServiceException(error);
        }
    }

    @Override
    public Return getById(Integer id) throws ServiceException {
        String error= "Unable to get expense by id : ";
        if (isNull(id)){
            throw new ServiceException(error + "id has null value");
        }
        try{
            return returnDAO.getById(id);
        }catch (DAOException ex){
            throw new ServiceException(error + ex.getMessage());
        }
    }

    @Override
    public Long create(Return obj) throws ServiceException {
        String error= "Unable to add expense: ";
        if (isNull(obj)){
            throw new ServiceException(error + "expense has null value");
        }
        try{
            Integer id = getAll().size();
            obj.setId(id);
            ReturnService clientService = new ReturnServiceImpl();
            Return client = clientService.getById((int)obj.getId());
            if (client == null){
                client = new Return();
                client.setId(obj.getId());
            }
            client.setSaleTime(obj.getSaleTime());
            client.setCount(obj.getCount());
            client.setReason(obj.getReason());
            client.setClientID(obj.getClientID());
            client.setEmployeeID(obj.getEmployeeID());
            client.setTourID(obj.getTourID());
            clientService.update(client);
            return returnDAO.add(obj);
        }catch (DAOException ex){
            throw new ServiceException(error + ex.getMessage());
        }
    }

    @Override
    public void update(Return obj) throws ServiceException {
        String error= "Unable to update expense: ";
        if (isNull(obj)){
            throw new ServiceException(error + "object has null value");
        }
        try{
            returnDAO.update(obj);
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
            returnDAO.delete(id);
        }catch (DAOException ex){
            throw new ServiceException();
        }
    }
}
