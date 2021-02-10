package by.bsuir.java.controller.command.impl;

import by.bsuir.java.controller.command.Command;
import by.bsuir.java.controller.command.exception.CommandException;
import by.bsuir.java.entity.Country;
import by.bsuir.java.service.CountryService;
import by.bsuir.java.service.exception.ServiceException;
import by.bsuir.java.service.factory.ServiceFactory;
import by.bsuir.java.view.tableview.impl.CountriesTableView;

import java.util.List;

public class AllCountries implements Command {
    @Override
    public String execute(String request) throws CommandException {
        String error = "Unable to execute AllTours command: ";
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CountryService saleService = serviceFactory.getCountryService();
        try {
            List<Country> countries =  saleService.getAll();
            response = new CountriesTableView().outputTable(countries);
        } catch (ServiceException e) {
            String message = error + e.getMessage();
            throw new CommandException(message, e);
        }
        return response;
    }
}
