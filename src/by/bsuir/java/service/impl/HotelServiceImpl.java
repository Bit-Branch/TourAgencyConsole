package by.bsuir.java.service.impl;


import by.bsuir.java.dao.HotelDAO;
import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.dao.factory.DAOFactory;

import by.bsuir.java.entity.Country;
import by.bsuir.java.entity.Hotel;
import by.bsuir.java.service.HotelService;
import by.bsuir.java.service.exception.ServiceException;
import by.bsuir.java.service.validator.ServiceValidator;

import java.util.List;

public class HotelServiceImpl implements HotelService, ServiceValidator {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private HotelDAO hotelDAO = daoFactory.getHotelDAO();

    @Override
    public List<Hotel> getAll(Integer idAccount) throws ServiceException {
        try{
            return hotelDAO.getAllByCountryId(idAccount);
        }catch (DAOException ex){
            String error = "Can not get all records in ExpenseServiceImpl: " + ex.getMessage();
            throw new ServiceException(error);
        }
    }

    @Override
    public List<Hotel> getAll() throws ServiceException {
        try{
            return hotelDAO.getAll();
        }catch (DAOException ex){
            String error = "Can not get all records in ExpenseServiceImpl: " + ex.getMessage();
            throw new ServiceException(error);
        }
    }

    @Override
    public Hotel getById(Integer id) throws ServiceException {
        String error= "Unable to get expense by id : ";
        if (isNull(id)){
            throw new ServiceException(error + "id has null value");
        }
        try{
            return hotelDAO.getById(id);
        }catch (DAOException ex){
            throw new ServiceException(error + ex.getMessage());
        }
    }

    @Override
    public Long create(Hotel obj) throws ServiceException {
        String error= "Unable to add expense: ";
        if (isNull(obj)){
            throw new ServiceException(error + "expense has null value");
        }
        try{
            Integer id = getAll().size();
            obj.setId(id);
            HotelService clientService = new HotelServiceImpl();
            Hotel client = clientService.getById((int)obj.getId());
            if (client == null){
                client = new Hotel();
                client.setId(obj.getId());
            }
            client.setName(obj.getName());
            client.setType(obj.getType());
            client.setDescription(obj.getDescription());
            client.setCountryID(obj.getCountryID());
            clientService.update(client);
            return hotelDAO.add(obj);
        }catch (DAOException ex){
            throw new ServiceException(error + ex.getMessage());
        }
    }

    @Override
    public void update(Hotel obj) throws ServiceException {
        String error= "Unable to update expense: ";
        if (isNull(obj)){
            throw new ServiceException(error + "object has null value");
        }
        try{
            hotelDAO.update(obj);
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
            hotelDAO.delete(id);
        }catch (DAOException ex){
            throw new ServiceException();
        }
    }
}
