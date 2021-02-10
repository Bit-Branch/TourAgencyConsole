package by.bsuir.java.controller.command.impl;

import by.bsuir.java.controller.command.Command;
import by.bsuir.java.controller.command.exception.CommandException;
import by.bsuir.java.controller.command.translator.exception.RequestTranslationException;
import by.bsuir.java.controller.command.translator.impl.AccountRequestTranslator;
import by.bsuir.java.controller.command.translator.impl.ClientRequestTranslator;
import by.bsuir.java.entity.Account;
import by.bsuir.java.entity.Client;
import by.bsuir.java.service.AccountService;
import by.bsuir.java.service.ClientService;
import by.bsuir.java.service.exception.ServiceException;
import by.bsuir.java.service.factory.ServiceFactory;

public class Register implements Command {

    @Override
    public String execute(String request) throws CommandException {
        String error = "Unable to execute Register command: ";
        AccountRequestTranslator accountRequestTranslator = new AccountRequestTranslator();
        ClientRequestTranslator clientRequestTranslator = new ClientRequestTranslator();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AccountService userService = serviceFactory.getAccountService();
        ClientService clientService = serviceFactory.getClientService();
        String response;
        try {
            Client client = clientRequestTranslator.translateToObject(request);
            Account user = accountRequestTranslator.translateToObject(request);
            userService.register(user);
            client.setAccountID(userService.getAll().get(userService.getAll().size()-1).getId());
            clientService.create(client);

            response = "Successfully registered ";
        } catch (ServiceException | RequestTranslationException ex){
            throw new CommandException(error + ex.getMessage(), ex);
        }
        return response;
    }
}
