package by.bsuir.java.dao.impl;


import by.bsuir.java.dao.CountryDAO;

import by.bsuir.java.dao.converter.impl.CountryConverter;
import by.bsuir.java.dao.datasource.DataSource;
import by.bsuir.java.dao.datasource.exception.DataSourceException;
import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.dao.validator.DAOValidator;
import by.bsuir.java.entity.Country;


import java.util.Iterator;
import java.util.List;

public class FileCountryDAO implements CountryDAO, DAOValidator {

    private DataSource<Country> dataSource;
    private CountryConverter countryConverter;

    public FileCountryDAO() {
        dataSource = new DataSource<>("/Countries.txt");
        countryConverter = new CountryConverter();
    }

    public FileCountryDAO(DataSource<Country> dataSource, CountryConverter accountConverter) {
        this.dataSource = dataSource;
        this.countryConverter = accountConverter;
    }

    public DataSource<Country> getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource<Country> dataSource) {
        this.dataSource = dataSource;
    }

    public CountryConverter getCountryConverter() {
        return countryConverter;
    }

    public void setCountryConverter(CountryConverter countryConverter) {
        this.countryConverter = countryConverter;
    }


    @Override
    public List<Country> getAll() throws DAOException {
        List<Country> users;
        try {
            users = dataSource.read(countryConverter);
        } catch (DataSourceException e) {
            String error = "Can not get all records in FileUserDAO: " + e.getMessage();
            throw new DAOException(error, e);
        }
        return users;
    }

    @Override
    public Country getById(Integer id) throws DAOException {
        String error = "Unable to get user by id : ";
        if (isNull(id)) {
            throw new DAOException(error + "id has null value");
        }
        Country profile = null;
        List<Country> users = getAll();
        for (Country user : users
        ) {
            if (user.getId() == id) {
                profile = user;
                break;
            }
        }
        return profile;
    }

    @Override
    public Long add(Country object) throws DAOException {
        String error = "Unable to add user: ";
        if (isNull(object)) {
            throw new DAOException(error + "user has null value");
        }
        try {
            dataSource.write(object, true, countryConverter);
        } catch (DataSourceException e) {
            throw new DAOException(error + e.getMessage(), e);
        }
        return object.getId();
    }

    @Override
    public void update(Country object) throws DAOException {
        String error = "Unable to update user: ";
        if (isNull(object)) {
            throw new DAOException(error + "object has null value");
        }
        List<Country> users = getAll();
        Iterator<Country> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            Country nextUser = userIterator.next();
            if (nextUser.getId() == object.getId()) {
                nextUser.setName(object.getName());
            }
        }
        try {
            dataSource.write(users, countryConverter);
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
        List<Country> users = getAll();
        Iterator<Country> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            Country nextUser = userIterator.next();
            if (nextUser.getId() == id) {
                userIterator.remove();
            }
        }
        try {
            dataSource.write(users, countryConverter);
        } catch (DataSourceException e) {
            throw new DAOException(error + e.getMessage(), e);
        }
    }

    }
