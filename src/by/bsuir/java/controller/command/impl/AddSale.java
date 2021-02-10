package by.bsuir.java.controller.command.impl;

import by.bsuir.java.controller.command.Command;
import by.bsuir.java.controller.command.exception.CommandException;
import by.bsuir.java.controller.command.translator.exception.RequestTranslationException;
import by.bsuir.java.controller.command.translator.impl.DiscountRequestTranslator;
import by.bsuir.java.controller.command.translator.impl.SaleRequestTranslator;
import by.bsuir.java.entity.Discount;
import by.bsuir.java.entity.Sale;
import by.bsuir.java.service.DiscountService;
import by.bsuir.java.service.SaleService;
import by.bsuir.java.service.exception.ServiceException;
import by.bsuir.java.service.factory.ServiceFactory;

public class AddSale implements Command {
    @Override
    public String execute(String request) throws CommandException {
        String error = "Unable to execute CreateExpense command: ";
        SaleRequestTranslator saleRequestTranslator = new SaleRequestTranslator();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SaleService saleService = serviceFactory.getSaleService();
        String response;
        try {
            Sale sale = saleRequestTranslator.translateToObject(request);
            saleService.create(sale);
            response = "Discount successfully added ";
        } catch (ServiceException | RequestTranslationException ex){
            throw new CommandException(error + ex.getMessage(), ex);
        }
        return response;
    }
}
