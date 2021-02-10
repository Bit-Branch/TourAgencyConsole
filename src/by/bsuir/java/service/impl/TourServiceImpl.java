package by.bsuir.java.service.impl;

import by.bsuir.java.dao.TourDAO;
import by.bsuir.java.dao.datasource.exception.DataSourceException;
import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.dao.factory.DAOFactory;
import by.bsuir.java.entity.Country;
import by.bsuir.java.entity.Return;
import by.bsuir.java.entity.Sale;
import by.bsuir.java.entity.Tour;
import by.bsuir.java.service.TourService;
import by.bsuir.java.service.exception.ServiceException;
import by.bsuir.java.service.validator.ServiceValidator;

import java.util.ArrayList;
import java.util.List;

public class TourServiceImpl implements TourService, ServiceValidator {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private TourDAO tourDAO = daoFactory.getTourDAO();


    @Override
    public List<Tour> getAll() throws ServiceException {
        try{
            return tourDAO.getAll();
        }catch (DAOException ex){
            String error = "Can not get all records in ExpenseServiceImpl: " + ex.getMessage();
            throw new ServiceException(error);
        }
    }

    @Override
    public Tour getById(Integer id) throws ServiceException {
        String error= "Unable to get expense by id : ";
        if (isNull(id)){
            throw new ServiceException(error + "id has null value");
        }
        try{
            return tourDAO.getById(id);
        }catch (DAOException ex){
            throw new ServiceException(error + ex.getMessage());
        }
    }

    @Override
    public Long create(Tour obj) throws ServiceException {
        String error= "Unable to add expense: ";
        if (isNull(obj)){
            throw new ServiceException(error + "expense has null value");
        }
        try{
            Integer id = getAll().size();
            obj.setId(id);
            TourService clientService = new TourServiceImpl();
            Tour client = clientService.getById((int)obj.getId());
            if (client == null){
                client = new Tour();
                client.setId(obj.getId());
            }
            client.setName(obj.getName());
            client.setPrice(obj.getPrice());
            client.setDepartureTime(obj.getDepartureTime());
            client.setDepartureCity(obj.getDepartureCity());
            client.setAdultsCount(obj.getAdultsCount());
            client.setChildrenCount(obj.getChildrenCount());
            client.setDaysCount(obj.getDaysCount());
            client.setNightsCount(obj.getNightsCount());
            client.setHotelID(obj.getHotelID());
            client.setDiscountID(obj.getDiscountID());
            clientService.update(client);
            return tourDAO.add(obj);
        }catch (DAOException ex){
            throw new ServiceException(error + ex.getMessage());
        }
    }

    @Override
    public void update(Tour obj) throws ServiceException {
        String error= "Unable to update expense: ";
        if (isNull(obj)){
            throw new ServiceException(error + "object has null value");
        }
        try{
            tourDAO.update(obj);
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
            tourDAO.delete(id);
        }catch (DAOException ex){
            throw new ServiceException();
        }
    }

    @Override
    public List<Tour> getAllByHotelId(Integer idAccount) throws ServiceException {
        try{
            return tourDAO.getAllByHotelId(idAccount);
        }catch (DAOException ex){
            String error = "Can not get all records in ExpenseServiceImpl: " + ex.getMessage();
            throw new ServiceException(error);
        }
    }

    @Override
    public List<Tour> getAllByDiscountId(Integer idAccount) throws ServiceException {
        try{
            return tourDAO.getAllByDiscountId(idAccount);
        }catch (DAOException ex){
            String error = "Can not get all records in ExpenseServiceImpl: " + ex.getMessage();
            throw new ServiceException(error);
        }
    }
}
