package by.bsuir.java.service;

import by.bsuir.java.entity.Client;
import by.bsuir.java.service.exception.ServiceException;

import java.util.List;

public interface ClientService extends Service<Client> {
    List<Client> getAll(Integer idAccount) throws ServiceException;
}

