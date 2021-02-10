package by.bsuir.java.dao.impl;

import by.bsuir.java.dao.DiscountDAO;
import by.bsuir.java.dao.converter.impl.DiscountConverter;
import by.bsuir.java.dao.datasource.DataSource;
import by.bsuir.java.dao.datasource.exception.DataSourceException;
import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.dao.validator.DAOValidator;
import by.bsuir.java.entity.Discount;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileDiscountDAO implements DiscountDAO, DAOValidator {

    private DataSource<Discount> dataSource;
    private DiscountConverter discountConverter;

    public FileDiscountDAO() {
        dataSource = new DataSource<>("/Discounts.txt");
        discountConverter = new DiscountConverter();
    }

    public FileDiscountDAO(DataSource<Discount> dataSource, DiscountConverter accountConverter) {
        this.dataSource = dataSource;
        this.discountConverter = accountConverter;
    }

    public DataSource<Discount> getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource<Discount> dataSource) {
        this.dataSource = dataSource;
    }

    public DiscountConverter getDiscountConverter() {
        return discountConverter;
    }

    public void setDiscountConverter(DiscountConverter discountConverter) {
        this.discountConverter = discountConverter;
    }


    @Override
    public List<Discount> getAll() throws DAOException {
        List<Discount> users;
        try {
            users = dataSource.read(discountConverter);
        } catch (DataSourceException e) {
            String error = "Can not get all records in FileUserDAO: " + e.getMessage();
            throw new DAOException(error, e);
        }
        return users;
    }

    @Override
    public Discount getById(Integer id) throws DAOException {
        String error = "Unable to get user by id : ";
        if (isNull(id)) {
            throw new DAOException(error + "id has null value");
        }
        Discount profile = null;
        List<Discount> users = getAll();
        for (Discount user : users
        ) {
            if (user.getId() == id) {
                profile = user;
                break;
            }
        }
        return profile;
    }

    @Override
    public Long add(Discount object) throws DAOException {
        String error = "Unable to add user: ";
        if (isNull(object)) {
            throw new DAOException(error + "user has null value");
        }
        try {
            dataSource.write(object, true, discountConverter);
        } catch (DataSourceException e) {
            throw new DAOException(error + e.getMessage(), e);
        }
        return object.getId();
    }

    @Override
    public void update(Discount object) throws DAOException {
        String error = "Unable to update user: ";
        if (isNull(object)) {
            throw new DAOException(error + "object has null value");
        }
        List<Discount> users = getAll();
        Iterator<Discount> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            Discount nextUser = userIterator.next();
            if (nextUser.getId() == object.getId()) {
                nextUser.setName(object.getName());
                nextUser.setSize(object.getSize());
            }
        }
        try {
            dataSource.write(users, discountConverter);
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
        List<Discount> users = getAll();
        Iterator<Discount> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            Discount nextUser = userIterator.next();
            if (nextUser.getId() == id) {
                userIterator.remove();
            }
        }
        try {
            dataSource.write(users, discountConverter);
        } catch (DataSourceException e) {
            throw new DAOException(error + e.getMessage(), e);
        }
    }


    }