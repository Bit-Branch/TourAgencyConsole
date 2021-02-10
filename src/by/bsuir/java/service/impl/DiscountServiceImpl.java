package by.bsuir.java.service.impl;


import by.bsuir.java.dao.DiscountDAO;
import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.dao.factory.DAOFactory;

import by.bsuir.java.entity.Country;
import by.bsuir.java.entity.Discount;
import by.bsuir.java.service.DiscountService;
import by.bsuir.java.service.exception.ServiceException;
import by.bsuir.java.service.validator.ServiceValidator;

import java.util.List;

public class DiscountServiceImpl implements DiscountService, ServiceValidator {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private DiscountDAO discountDAO = daoFactory.getDiscountDAO();


    @Override
    public List<Discount> getAll() throws ServiceException {
        try{
            return discountDAO.getAll();
        }catch (DAOException ex){
            String error = "Can not get all records in ExpenseServiceImpl: " + ex.getMessage();
            throw new ServiceException(error);
        }
    }

    @Override
    public Discount getById(Integer id) throws ServiceException {
        String error= "Unable to get expense by id : ";
        if (isNull(id)){
            throw new ServiceException(error + "id has null value");
        }
        try{
            return discountDAO.getById(id);
        }catch (DAOException ex){
            throw new ServiceException(error + ex.getMessage());
        }
    }

    @Override
    public Long create(Discount obj) throws ServiceException {
        String error= "Unable to add expense: ";
        if (isNull(obj)){
            throw new ServiceException(error + "expense has null value");
        }
        try{
            Integer id = getAll().size();
            obj.setId(id);
            DiscountService discountService = new DiscountServiceImpl();
            Discount client = discountService.getById((int)obj.getId());
            if (client == null){
                client = new Discount();
                client.setId(obj.getId());
            }
            client.setName(obj.getName());
            client.setSize(obj.getSize());
            discountService.update(client);
            return discountDAO.add(obj);
        }catch (DAOException ex){
            throw new ServiceException(error + ex.getMessage());
        }
    }

    @Override
    public void update(Discount obj) throws ServiceException {
        String error= "Unable to update expense: ";
        if (isNull(obj)){
            throw new ServiceException(error + "object has null value");
        }
        try{
            discountDAO.update(obj);
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
            discountDAO.delete(id);
        }catch (DAOException ex){
            throw new ServiceException();
        }
    }
}
