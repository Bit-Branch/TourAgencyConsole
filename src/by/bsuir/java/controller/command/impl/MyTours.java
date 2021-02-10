package by.bsuir.java.controller.command.impl;

import by.bsuir.java.controller.command.Command;
import by.bsuir.java.entity.Client;
import by.bsuir.java.entity.Sale;
import by.bsuir.java.service.ClientService;
import by.bsuir.java.service.SaleService;
import by.bsuir.java.service.exception.ServiceException;
import by.bsuir.java.service.factory.ServiceFactory;
import by.bsuir.java.view.tableview.impl.SalesTableView;

import java.util.List;

public class MyTours implements Command {
    @Override
    public String execute(String request) {
        String[] args = request.split("[$]");
        Integer id = Integer.parseInt(args[1]);
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SaleService expenseService = serviceFactory.getSaleService();
        ClientService clientService = serviceFactory.getClientService();
        try {
            Client client = clientService.getAll(id).get(0);
            List<Sale> sales = expenseService.getAllByClientId((int) client.getId());
            response = new SalesTableView().outputTable(sales);
        } catch (ServiceException ex){
            response = "Error during getting all expenses";
        }
        return response;
    }
}
