package by.bsuir.java.controller.command.impl;

import by.bsuir.java.controller.command.Command;
import by.bsuir.java.controller.command.exception.CommandException;
import by.bsuir.java.entity.Sale;
import by.bsuir.java.service.SaleService;
import by.bsuir.java.service.exception.ServiceException;
import by.bsuir.java.service.factory.ServiceFactory;
import by.bsuir.java.view.tableview.impl.SalesTableView;

import java.util.List;

public class AllSales implements Command {
    @Override
    public String execute(String request) throws CommandException {
        String error = "Unable to execute AllTours command: ";
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SaleService saleService = serviceFactory.getSaleService();
        try {
            List<Sale> sales =  saleService.getAll();
            response = new SalesTableView().outputTable(sales);
        } catch (ServiceException e) {
            String message = error + e.getMessage();
            throw new CommandException(message, e);
        }
        return response;
    }
}
