package by.bsuir.java.controller.command.impl;

import by.bsuir.java.controller.command.Command;
import by.bsuir.java.controller.command.exception.CommandException;
import by.bsuir.java.service.TourService;
import by.bsuir.java.service.exception.ServiceException;
import by.bsuir.java.service.factory.ServiceFactory;

public class DeleteTour implements Command {
    @Override
    public String execute(String request) throws CommandException {
        String error = "Unable to execute DeleteExpense command: ";
        String[] args = request.split("[$]");
        Integer id = Integer.parseInt(args[1]);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TourService expenseService = serviceFactory.getTourService();
        String response;
        try {
            expenseService.delete(id);
            response = "Expense successfully deleted ";
        } catch (ServiceException ex){
            throw new CommandException(error + ex.getMessage(), ex);
        }
        return response;
    }
}
