package by.bsuir.java.dao.impl;


import by.bsuir.java.dao.ReturnDAO;

import by.bsuir.java.dao.converter.impl.ReturnConverter;
import by.bsuir.java.dao.datasource.DataSource;
import by.bsuir.java.dao.datasource.exception.DataSourceException;
import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.dao.validator.DAOValidator;
import by.bsuir.java.entity.Return;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileReturnDAO implements ReturnDAO, DAOValidator {

    private DataSource<Return> dataSource;
    private ReturnConverter returnConverter;

    public FileReturnDAO() {
        dataSource = new DataSource<>("/Returns.txt");
        returnConverter = new ReturnConverter();
    }

    public FileReturnDAO(DataSource<Return> dataSource, ReturnConverter accountConverter) {
        this.dataSource = dataSource;
        this.returnConverter = accountConverter;
    }

    public DataSource<Return> getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource<Return> dataSource) {
        this.dataSource = dataSource;
    }

    public ReturnConverter getReturnConverter() {
        return returnConverter;
    }

    public void setReturnConverter(ReturnConverter returnConverter) {
        this.returnConverter = returnConverter;
    }


    @Override
    public List<Return> getAll() throws DAOException {
        List<Return> users;
        try {
            users = dataSource.read(returnConverter);
        } catch (DataSourceException e) {
            String error = "Can not get all records in FileUserDAO: " + e.getMessage();
            throw new DAOException(error, e);
        }
        return users;
    }

    @Override
    public Return getById(Integer id) throws DAOException {
        String error = "Unable to get user by id : ";
        if (isNull(id)) {
            throw new DAOException(error + "id has null value");
        }
        Return profile = null;
        List<Return> users = getAll();
        for (Return user : users
        ) {
            if (user.getId() == id) {
                profile = user;
                break;
            }
        }
        return profile;
    }

    @Override
    public Long add(Return object) throws DAOException {
        String error = "Unable to add user: ";
        if (isNull(object)) {
            throw new DAOException(error + "user has null value");
        }
        try {
            dataSource.write(object, true, returnConverter);
        } catch (DataSourceException e) {
            throw new DAOException(error + e.getMessage(), e);
        }
        return object.getId();
    }

    @Override
    public void update(Return object) throws DAOException {
        String error = "Unable to update user: ";
        if (isNull(object)) {
            throw new DAOException(error + "object has null value");
        }
        List<Return> users = getAll();
        Iterator<Return> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            Return nextUser = userIterator.next();
            if (nextUser.getId() == object.getId()) {
                nextUser.setSaleTime(object.getSaleTime());
                nextUser.setCount(object.getCount());
                nextUser.setReason(object.getReason());
                nextUser.setClientID(object.getClientID());
                nextUser.setEmployeeID(object.getEmployeeID());
                nextUser.setTourID(object.getTourID());
            }
        }
        try {
            dataSource.write(users, returnConverter);
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
        List<Return> users = getAll();
        Iterator<Return> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            Return nextUser = userIterator.next();
            if (nextUser.getId() == id) {
                userIterator.remove();
            }
        }
        try {
            dataSource.write(users, returnConverter);
        } catch (DataSourceException e) {
            throw new DAOException(error + e.getMessage(), e);
        }
    }

    @Override
    public List<Return> getAllByClientId(Integer idClient) throws DAOException {
        String error = "Unable to get clients by id: ";
        if (isNull(idClient)) {
            throw new DAOException(error + "idClient has null value");
        }
        List<Return> dataSourceExpenseList;
        List<Return> expenseList = new ArrayList<>();
        try {
            dataSourceExpenseList = dataSource.read(returnConverter);
            for (Return expense : dataSourceExpenseList
            ) {
                if (idClient == expense.getClientID()) {
                    expenseList.add(expense);
                }
            }
        } catch (DataSourceException e) {
            throw new DAOException(error + e.getMessage(), e);
        }
        return expenseList;
    }

    @Override
    public List<Return> getAllByEmployeeId(Integer idEmployee) throws DAOException {
        String error = "Unable to get clients by id: ";
        if (isNull(idEmployee)) {
            throw new DAOException(error + "idEmployee has null value");
        }
        List<Return> dataSourceExpenseList;
        List<Return> expenseList = new ArrayList<>();
        try {
            dataSourceExpenseList = dataSource.read(returnConverter);
            for (Return expense : dataSourceExpenseList
            ) {
                if (idEmployee == expense.getEmployeeID()) {
                    expenseList.add(expense);
                }
            }
        } catch (DataSourceException e) {
            throw new DAOException(error + e.getMessage(), e);
        }
        return expenseList;
    }

    @Override
    public List<Return> getAllByTourId(Integer idTour) throws DAOException {
        String error = "Unable to get clients by id: ";
        if (isNull(idTour)) {
            throw new DAOException(error + "idTour has null value");
        }
        List<Return> dataSourceExpenseList;
        List<Return> expenseList = new ArrayList<>();
        try {
            dataSourceExpenseList = dataSource.read(returnConverter);
            for (Return expense : dataSourceExpenseList
            ) {
                if (idTour == expense.getTourID()) {
                    expenseList.add(expense);
                }
            }
        } catch (DataSourceException e) {
            throw new DAOException(error + e.getMessage(), e);
        }
        return expenseList;
    }
}
