package by.bsuir.java.controller.command.impl;

import by.bsuir.java.controller.command.Command;
import by.bsuir.java.controller.command.exception.CommandException;
import by.bsuir.java.entity.Employee;
import by.bsuir.java.service.EmployeeService;
import by.bsuir.java.service.exception.ServiceException;
import by.bsuir.java.service.factory.ServiceFactory;
import by.bsuir.java.view.tableview.impl.EmployeesTableView;

import java.util.List;

public class AllHotels implements Command {
    @Override
    public String execute(String request) throws CommandException {
        String error = "Unable to execute AllTours command: ";
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EmployeeService saleService = serviceFactory.getEmployeeService();
        try {
            List<Employee> employees =  saleService.getAll();
            response = new EmployeesTableView().outputTable(employees);
        } catch (ServiceException e) {
            String message = error + e.getMessage();
            throw new CommandException(message, e);
        }
        return response;
    }
}

