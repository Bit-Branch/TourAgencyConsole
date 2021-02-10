package by.bsuir.java.dao.impl;

import by.bsuir.java.dao.ClientDAO;

import by.bsuir.java.dao.converter.impl.ClientConverter;
import by.bsuir.java.dao.datasource.DataSource;
import by.bsuir.java.dao.datasource.exception.DataSourceException;
import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.dao.validator.DAOValidator;
import by.bsuir.java.entity.Client;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileClientDAO implements ClientDAO, DAOValidator {

    private DataSource<Client> dataSource;
    private ClientConverter clientConverter;

    public FileClientDAO() {
        dataSource = new DataSource<>("/Clients.txt");
        clientConverter = new ClientConverter();
    }

    public FileClientDAO(DataSource<Client> dataSource, ClientConverter accountConverter) {
        this.dataSource = dataSource;
        this.clientConverter = accountConverter;
    }

    public DataSource<Client> getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource<Client> dataSource) {
        this.dataSource = dataSource;
    }

    public ClientConverter getClientConverter() {
        return clientConverter;
    }

    public void setClientConverter(ClientConverter clientConverter) {
        this.clientConverter = clientConverter;
    }


    @Override
    public List<Client> getAll() throws DAOException {
        List<Client> clients;
        try {
            clients = dataSource.read(clientConverter);
        } catch (DataSourceException e) {
            String error = "Can not get all records in FileUserDAO: " + e.getMessage();
            throw new DAOException(error, e);
        }
        return clients;
    }

    @Override
    public Client getById(Integer id) throws DAOException {
        String error = "Unable to get user by id : ";
        if (isNull(id)) {
            throw new DAOException(error + "id has null value");
        }
        Client profile = null;
        List<Client> clients = getAll();
        for (Client client : clients
        ) {
            if (client.getId() == id) {
                profile = client;
                break;
            }
        }
        return profile;
    }

    @Override
    public Long add(Client object) throws DAOException {
        String error = "Unable to add user: ";
        if (isNull(object)) {
            throw new DAOException(error + "user has null value");
        }
        try {
            dataSource.write(object, true, clientConverter);
        } catch (DataSourceException e) {
            throw new DAOException(error + e.getMessage(), e);
        }
        return object.getId();
    }

    @Override
    public void update(Client object) throws DAOException {
        String error = "Unable to update user: ";
        if (isNull(object)) {
            throw new DAOException(error + "object has null value");
        }
        List<Client> clients = getAll();
        Iterator<Client> clientIterator = clients.iterator();
        while (clientIterator.hasNext()) {
            Client next = clientIterator.next();
            if (next.getId() == object.getId()) {
                next.setSurname(object.getSurname());
                next.setName(object.getName());
                next.setPatronymic(object.getPatronymic());
                next.setPassport(object.getPassport());
                next.setEmail(object.getEmail());
                next.setPhone(object.getPhone());
                next.setAccountID(object.getAccountID());
            }
        }
        try {
            dataSource.write(clients, clientConverter);
        } catch (DataSourceException e) {
            throw new DAOException(error + e.getMessage(), e);
        }
    }

    @Override
    public void delete(Integer id) throws DAOException {
        String error = "Unable to delete user: ";
        if (isNull(id)) {
            throw new DAOException(error + "object has null value");
        }
        List<Client> clients = getAll();
        Iterator<Client> clientIterator = clients.iterator();
        while (clientIterator.hasNext()) {
            Client next = clientIterator.next();
            if (next.getId() == id) {
                clientIterator.remove();
            }
        }
        try {
            dataSource.write(clients, clientConverter);
        } catch (DataSourceException e) {
            throw new DAOException(error + e.getMessage(), e);
        }
    }

    @Override
    public List<Client> getAllByAccountId(Integer idAccount) throws DAOException {
        String error= "Unable to get clients by id: ";
        if (isNull(idAccount)){
            throw new DAOException(error + "idAccount has null value");
        }
        List<Client> clientList;
        List<Client> expenseList = new ArrayList<>();
        try{
            clientList = dataSource.read(clientConverter);
            for (Client expense:clientList
            ) {
                if (idAccount == expense.getAccountID()){
                    expenseList.add(expense);
                }
            }
        } catch (DataSourceException e) {
            throw new DAOException(error + e.getMessage(), e);
        }
        return expenseList;
    }
}
