package by.bsuir.java.controller.command.impl;

import by.bsuir.java.controller.command.Command;
import by.bsuir.java.controller.command.exception.CommandException;
import by.bsuir.java.entity.Account;
import by.bsuir.java.service.AccountService;
import by.bsuir.java.service.exception.ServiceException;
import by.bsuir.java.service.factory.ServiceFactory;
import by.bsuir.java.view.tableview.impl.AccountsTableView;

import java.util.List;

public class AllAccounts implements Command {
    @Override
    public String execute(String request) throws CommandException {
        String error = "Unable to execute AllTours command: ";
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AccountService saleService = serviceFactory.getAccountService();
        try {
            List<Account> accounts =  saleService.getAll();
            response = new AccountsTableView().outputTable(accounts);
        } catch (ServiceException e) {
            String message = error + e.getMessage();
            throw new CommandException(message, e);
        }
        return response;
    }
}
