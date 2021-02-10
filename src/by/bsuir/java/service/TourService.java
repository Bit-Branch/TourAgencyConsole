package by.bsuir.java.service;

import by.bsuir.java.entity.Sale;
import by.bsuir.java.entity.Tour;
import by.bsuir.java.service.exception.ServiceException;

import java.util.List;

public interface TourService extends Service<Tour> {
    List<Tour> getAllByHotelId(Integer idHotel) throws ServiceException;
    List<Tour> getAllByDiscountId(Integer idDiscount) throws ServiceException;
}
