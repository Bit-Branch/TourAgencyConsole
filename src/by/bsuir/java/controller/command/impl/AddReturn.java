package by.bsuir.java.controller.command.impl;

import by.bsuir.java.controller.command.Command;
import by.bsuir.java.controller.command.exception.CommandException;
import by.bsuir.java.controller.command.translator.exception.RequestTranslationException;
import by.bsuir.java.controller.command.translator.impl.ReturnRequestTranslator;
import by.bsuir.java.controller.command.translator.impl.SaleRequestTranslator;
import by.bsuir.java.entity.Return;
import by.bsuir.java.entity.Sale;
import by.bsuir.java.service.ReturnService;
import by.bsuir.java.service.SaleService;
import by.bsuir.java.service.exception.ServiceException;
import by.bsuir.java.service.factory.ServiceFactory;

public class AddReturn implements Command {
    @Override
    public String execute(String request) throws CommandException {
        String error = "Unable to execute CreateExpense command: ";
        ReturnRequestTranslator returnRequestTranslator = new ReturnRequestTranslator();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ReturnService returnService = serviceFactory.getReturnService();
        String response;
        try {
            Return aReturn = returnRequestTranslator.translateToObject(request);
            returnService.create(aReturn);
            response = "Discount successfully added ";
        } catch (ServiceException | RequestTranslationException ex){
            throw new CommandException(error + ex.getMessage(), ex);
        }
        return response;
    }
}
