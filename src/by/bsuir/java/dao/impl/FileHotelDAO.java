package by.bsuir.java.dao.impl;


import by.bsuir.java.dao.HotelDAO;
import by.bsuir.java.dao.converter.impl.HotelConverter;
import by.bsuir.java.dao.datasource.DataSource;
import by.bsuir.java.dao.datasource.exception.DataSourceException;
import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.dao.validator.DAOValidator;
import by.bsuir.java.entity.Hotel;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileHotelDAO implements HotelDAO, DAOValidator {

    private DataSource<Hotel> dataSource;
    private HotelConverter hotelConverter;

    public FileHotelDAO() {
        dataSource = new DataSource<>("/Hotels.txt");
        hotelConverter = new HotelConverter();
    }

    public FileHotelDAO(DataSource<Hotel> dataSource, HotelConverter accountConverter) {
        this.dataSource = dataSource;
        this.hotelConverter = accountConverter;
    }

    public DataSource<Hotel> getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource<Hotel> dataSource) {
        this.dataSource = dataSource;
    }

    public HotelConverter getHotelConverter() {
        return hotelConverter;
    }

    public void setHotelConverter(HotelConverter hotelConverter) {
        this.hotelConverter = hotelConverter;
    }


    @Override
    public List<Hotel> getAll() throws DAOException {
        List<Hotel> users;
        try {
            users = dataSource.read(hotelConverter);
        } catch (DataSourceException e) {
            String error = "Can not get all records in FileUserDAO: " + e.getMessage();
            throw new DAOException(error, e);
        }
        return users;
    }

    @Override
    public Hotel getById(Integer id) throws DAOException {
        String error = "Unable to get user by id : ";
        if (isNull(id)) {
            throw new DAOException(error + "id has null value");
        }
        Hotel profile = null;
        List<Hotel> users = getAll();
        for (Hotel user : users
        ) {
            if (user.getId() == id) {
                profile = user;
                break;
            }
        }
        return profile;
    }

    @Override
    public Long add(Hotel object) throws DAOException {
        String error = "Unable to add user: ";
        if (isNull(object)) {
            throw new DAOException(error + "user has null value");
        }
        try {
            dataSource.write(object, true, hotelConverter);
        } catch (DataSourceException e) {
            throw new DAOException(error + e.getMessage(), e);
        }
        return object.getId();
    }

    @Override
    public void update(Hotel object) throws DAOException {
        String error = "Unable to update user: ";
        if (isNull(object)) {
            throw new DAOException(error + "object has null value");
        }
        List<Hotel> users = getAll();
        Iterator<Hotel> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            Hotel nextUser = userIterator.next();
            if (nextUser.getId() == object.getId()) {
                nextUser.setName(object.getName());
                nextUser.setType(object.getType());
                nextUser.setDescription(object.getDescription());
                nextUser.setCountryID(object.getCountryID());
            }
        }
        try {
            dataSource.write(users, hotelConverter);
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
        List<Hotel> users = getAll();
        Iterator<Hotel> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            Hotel nextUser = userIterator.next();
            if (nextUser.getId() == id) {
                userIterator.remove();
            }
        }
        try {
            dataSource.write(users, hotelConverter);
        } catch (DataSourceException e) {
            throw new DAOException(error + e.getMessage(), e);
        }
    }



    @Override
    public List<Hotel> getAllByCountryId(Integer idCountry) throws DAOException {
        String error = "Unable to get clients by id: ";
        if (isNull(idCountry)) {
            throw new DAOException(error + "idCountry has null value");
        }
        List<Hotel> dataSourceExpenseList;
        List<Hotel> expenseList = new ArrayList<>();
        try {
            dataSourceExpenseList = dataSource.read(hotelConverter);
            for (Hotel expense : dataSourceExpenseList
            ) {
                if (idCountry == expense.getCountryID()) {
                    expenseList.add(expense);
                }
            }
        } catch (DataSourceException e) {
            throw new DAOException(error + e.getMessage(), e);
        }
        return expenseList;
    }
}

