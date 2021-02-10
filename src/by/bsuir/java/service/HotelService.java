package by.bsuir.java.service;

import by.bsuir.java.entity.Client;
import by.bsuir.java.entity.Hotel;
import by.bsuir.java.service.exception.ServiceException;

import java.util.List;

public interface HotelService extends Service<Hotel> {
    List<Hotel> getAll(Integer idCountry) throws ServiceException;
}
