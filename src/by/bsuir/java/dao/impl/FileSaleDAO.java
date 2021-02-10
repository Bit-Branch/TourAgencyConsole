package by.bsuir.java.dao.impl;

import by.bsuir.java.dao.SaleDAO;
import by.bsuir.java.dao.converter.impl.SaleConverter;
import by.bsuir.java.dao.datasource.DataSource;
import by.bsuir.java.dao.datasource.exception.DataSourceException;
import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.dao.validator.DAOValidator;
import by.bsuir.java.entity.Sale;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileSaleDAO implements SaleDAO, DAOValidator {

    private DataSource<Sale> dataSource;
    private SaleConverter saleConverter;

    public FileSaleDAO() {
        dataSource = new DataSource<>("/Sales.txt");
        saleConverter = new SaleConverter();
    }

    public FileSaleDAO(DataSource<Sale> dataSource, SaleConverter accountConverter) {
        this.dataSource = dataSource;
        this.saleConverter = accountConverter;
    }

    public DataSource<Sale> getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource<Sale> dataSource) {
        this.dataSource = dataSource;
    }

    public SaleConverter getSaleConverter() {
        return saleConverter;
    }

    public void setSaleConverter(SaleConverter saleConverter) {
        this.saleConverter = saleConverter;
    }


    @Override
    public List<Sale> getAll() throws DAOException {
        List<Sale> users;
        try {
            users = dataSource.read(saleConverter);
        } catch (DataSourceException e) {
            String error = "Can not get all records in FileUserDAO: " + e.getMessage();
            throw new DAOException(error, e);
        }
        return users;
    }

    @Override
    public Sale getById(Integer id) throws DAOException {
        String error = "Unable to get user by id : ";
        if (isNull(id)) {
            throw new DAOException(error + "id has null value");
        }
        Sale profile = null;
        List<Sale> users = getAll();
        for (Sale user : users
        ) {
            if (user.getId() == id) {
                profile = user;
                break;
            }
        }
        return profile;
    }

    @Override
    public Long add(Sale object) throws DAOException {
        String error = "Unable to add user: ";
        if (isNull(object)) {
            throw new DAOException(error + "user has null value");
        }
        try {
            dataSource.write(object, true, saleConverter);
        } catch (DataSourceException e) {
            throw new DAOException(error + e.getMessage(), e);
        }
        return object.getId();
    }

    @Override
    public void update(Sale object) throws DAOException {
        String error = "Unable to update user: ";
        if (isNull(object)) {
            throw new DAOException(error + "object has null value");
        }
        List<Sale> users = getAll();
        Iterator<Sale> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            Sale nextUser = userIterator.next();
            if (nextUser.getId() == object.getId()) {
                nextUser.setSaleTime(object.getSaleTime());
                nextUser.setCount(object.getCount());
                nextUser.setClientID(object.getClientID());
                nextUser.setEmployeeID(object.getEmployeeID());
                nextUser.setTourID(object.getTourID());
            }
        }
        try {
            dataSource.write(users, saleConverter);
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
        List<Sale> users = getAll();
        Iterator<Sale> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            Sale nextUser = userIterator.next();
            if (nextUser.getId() == id) {
                userIterator.remove();
            }
        }
        try {
            dataSource.write(users, saleConverter);
        } catch (DataSourceException e) {
            throw new DAOException(error + e.getMessage(), e);
        }
    }

    @Override
    public List<Sale> getAllByClientId(Integer idClient) throws DAOException {
        String error = "Unable to get clients by id: ";
        if (isNull(idClient)) {
            throw new DAOException(error + "idClient has null value");
        }
        List<Sale> dataSourceExpenseList;
        List<Sale> expenseList = new ArrayList<>();
        try {
            dataSourceExpenseList = dataSource.read(saleConverter);
            for (Sale expense : dataSourceExpenseList
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
    public List<Sale> getAllByEmployeeId(Integer idEmployee) throws DAOException {
        String error = "Unable to get clients by id: ";
        if (isNull(idEmployee)) {
            throw new DAOException(error + "idAccount has null value");
        }
        List<Sale> dataSourceExpenseList;
        List<Sale> expenseList = new ArrayList<>();
        try {
            dataSourceExpenseList = dataSource.read(saleConverter);
            for (Sale expense : dataSourceExpenseList
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
    public List<Sale> getAllByTourId(Integer idTour) throws DAOException {
        String error = "Unable to get clients by id: ";
        if (isNull(idTour)) {
            throw new DAOException(error + "idTour has null value");
        }
        List<Sale> dataSourceExpenseList;
        List<Sale> expenseList = new ArrayList<>();
        try {
            dataSourceExpenseList = dataSource.read(saleConverter);
            for (Sale expense : dataSourceExpenseList
            ) {
                if (idTour == (expense.getTourID())) {
                    expenseList.add(expense);
                }
            }
        } catch (DataSourceException e) {
            throw new DAOException(error + e.getMessage(), e);
        }
        return expenseList;
    }
}
