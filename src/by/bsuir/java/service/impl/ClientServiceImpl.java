package by.bsuir.java.service.impl;

import by.bsuir.java.dao.ClientDAO;
import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.dao.factory.DAOFactory;
import by.bsuir.java.entity.Client;
import by.bsuir.java.service.ClientService;
import by.bsuir.java.service.exception.ServiceException;
import by.bsuir.java.service.validator.ServiceValidator;

import java.util.List;

public class ClientServiceImpl implements ClientService, ServiceValidator {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private ClientDAO clientDAO = daoFactory.getClientDAO();

    @Override
    public List<Client> getAll(Integer idAccount) throws ServiceException {
        try{
            return clientDAO.getAllByAccountId(idAccount);
        }catch (DAOException ex){
            String error = "Can not get all records in ExpenseServiceImpl: " + ex.getMessage();
            throw new ServiceException(error);
        }
    }

    @Override
    public List<Client> getAll() throws ServiceException {
        try{
            return clientDAO.getAll();
        }catch (DAOException ex){
            String error = "Can not get all records in ExpenseServiceImpl: " + ex.getMessage();
            throw new ServiceException(error);
        }
    }

    @Override
    public Client getById(Integer id) throws ServiceException {
        String error= "Unable to get expense by id : ";
        if (isNull(id)){
            throw new ServiceException(error + "id has null value");
        }
        try{
            return clientDAO.getById(id);
        }catch (DAOException ex){
            throw new ServiceException(error + ex.getMessage());
        }
    }

    @Override
    public Long create(Client obj) throws ServiceException {
        String error= "Unable to add expense: ";
        if (isNull(obj)){
            throw new ServiceException(error + "expense has null value");
        }
        try{
            Integer id = getAll().size();
            obj.setId(id);
            ClientService clientService = new ClientServiceImpl();
            Client client = clientService.getById((int)obj.getAccountID());
            if(client == null){
                client = new Client();
                client.setId(obj.getId());
            }
            client.setSurname(obj.getSurname());
            client.setName(obj.getName());
            client.setPatronymic(obj.getPatronymic());
            client.setPassport(obj.getPassport());
            client.setEmail(obj.getEmail());
            client.setPhone(obj.getPhone());
            client.setAccountID(obj.getAccountID());
            clientService.update(client);
            return clientDAO.add(obj);
        }catch (DAOException ex){
            throw new ServiceException(error + ex.getMessage());
        }
    }

    @Override
    public void update(Client obj) throws ServiceException {
        String error= "Unable to update expense: ";
        if (isNull(obj)){
            throw new ServiceException(error + "object has null value");
        }
        try{
            clientDAO.update(obj);
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
            clientDAO.delete(id);
        }catch (DAOException ex){
            throw new ServiceException();
        }
    }
}
