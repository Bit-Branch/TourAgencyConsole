package by.bsuir.java.service.impl;


import by.bsuir.java.dao.CountryDAO;
import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.dao.factory.DAOFactory;

import by.bsuir.java.entity.Country;
import by.bsuir.java.service.CountryService;
import by.bsuir.java.service.exception.ServiceException;
import by.bsuir.java.service.validator.ServiceValidator;

import java.util.List;

public class CountryServiceImpl implements CountryService, ServiceValidator {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private CountryDAO countryDAO = daoFactory.getCountryDAO();


    @Override
    public List<Country> getAll() throws ServiceException {
        try{
            return countryDAO.getAll();
        }catch (DAOException ex){
            String error = "Can not get all records in ExpenseServiceImpl: " + ex.getMessage();
            throw new ServiceException(error);
        }
    }

    @Override
    public Country getById(Integer id) throws ServiceException {
        String error= "Unable to get expense by id : ";
        if (isNull(id)){
            throw new ServiceException(error + "id has null value");
        }
        try{
            return countryDAO.getById(id);
        }catch (DAOException ex){
            throw new ServiceException(error + ex.getMessage());
        }
    }

    @Override
    public Long create(Country obj) throws ServiceException {
        String error= "Unable to add expense: ";
        if (isNull(obj)){
            throw new ServiceException(error + "expense has null value");
        }
        try{
            Integer id = getAll().size();
            obj.setId(id);
            CountryService clientService = new CountryServiceImpl();
            Country client = clientService.getById((int)obj.getId());
            if (client == null){
                client = new Country();
                client.setId(obj.getId());
            }
            client.setName(obj.getName());
            clientService.update(client);
            return countryDAO.add(obj);
        }catch (DAOException ex){
            throw new ServiceException(error + ex.getMessage());
        }
    }

    @Override
    public void update(Country obj) throws ServiceException {
        String error= "Unable to update expense: ";
        if (isNull(obj)){
            throw new ServiceException(error + "object has null value");
        }
        try{
            countryDAO.update(obj);
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
            countryDAO.delete(id);
        }catch (DAOException ex){
            throw new ServiceException();
        }
    }
}
