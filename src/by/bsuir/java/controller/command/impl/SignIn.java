package by.bsuir.java.controller.command.impl;

import by.bsuir.java.controller.command.Command;
import by.bsuir.java.controller.command.translator.exception.RequestTranslationException;
import by.bsuir.java.controller.command.translator.impl.AccountRequestTranslator;
import by.bsuir.java.entity.Account;
import by.bsuir.java.service.AccountService;
import by.bsuir.java.service.exception.ServiceException;
import by.bsuir.java.service.factory.ServiceFactory;

public class SignIn implements Command {
    @Override
    public String execute(String request) {
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AccountService userService = serviceFactory.getAccountService();
        try {
            AccountRequestTranslator userRequestTranslator = new AccountRequestTranslator();
            Account user = userRequestTranslator.translate(request);
            user = userService.signIn(user.getLogin(),user.getPassword());
            response = user.getId() + "," + user.getLogin() + "," + user.getPassword() + "," + user.getRole();
        } catch (ServiceException | RequestTranslationException ex){
            response = "Error during sign in";
        }
        return response;
    }
}
