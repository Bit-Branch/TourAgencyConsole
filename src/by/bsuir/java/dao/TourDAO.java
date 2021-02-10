package by.bsuir.java.dao;

import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.entity.Tour;


import java.util.List;

public interface TourDAO extends DAO<Tour>{
	List<Tour> getAllByHotelId(Integer idHotel) throws DAOException;
	List<Tour> getAllByDiscountId(Integer idDiscount) throws DAOException;
}
