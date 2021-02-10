package by.bsuir.java.dao;

import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.entity.Client;
import by.bsuir.java.entity.Hotel;

import java.util.List;

public interface HotelDAO extends DAO<Hotel>{
    List<Hotel> getAllByCountryId(Integer idCountry) throws DAOException;
}