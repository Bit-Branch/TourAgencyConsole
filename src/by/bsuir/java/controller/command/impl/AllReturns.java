package by.bsuir.java.controller.command.impl;

import by.bsuir.java.controller.command.Command;
import by.bsuir.java.controller.command.exception.CommandException;
import by.bsuir.java.entity.Return;
import by.bsuir.java.service.ReturnService;
import by.bsuir.java.service.exception.ServiceException;
import by.bsuir.java.service.factory.ServiceFactory;
import by.bsuir.java.view.tableview.impl.ReturnsTableView;

import java.util.List;

public class AllReturns implements Command {
    @Override
    public String execute(String request) throws CommandException {
        String error = "Unable to execute AllTours command: ";
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ReturnService saleService = serviceFactory.getReturnService();
        try {
            List<Return> returns =  saleService.getAll();
            response = new ReturnsTableView().outputTable(returns);
        } catch (ServiceException e) {
            String message = error + e.getMessage();
            throw new CommandException(message, e);
        }
        return response;
    }
}
