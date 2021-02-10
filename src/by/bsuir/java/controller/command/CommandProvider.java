package by.bsuir.java.controller.command;



import by.bsuir.java.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<CommandName,Command> repository = new HashMap<>();

    public CommandProvider(){


        repository.put(CommandName.SIGN_IN,new SignIn());
        repository.put(CommandName.ALL_TOURS,new AllTours());
        repository.put(CommandName.ADD_DISCOUNT, new AddDiscount());
        repository.put(CommandName.ADD_HOTEL, new AddHotel());
        repository.put(CommandName.ALL_SALES, new AllSales());
        repository.put(CommandName.ALL_RETURNS, new AllReturns());
        repository.put(CommandName.ALL_COUNTRIES, new AllCountries());
        repository.put(CommandName.REGISTER, new Register());
        repository.put(CommandName.DELETE_TOUR, new DeleteTour());
        repository.put(CommandName.ADD_SALE, new AddSale());
        repository.put(CommandName.ADD_RETURN, new AddReturn());
        repository.put(CommandName.MY_TOURS, new MyTours());
        repository.put(CommandName.DELETE_SALE, new DeleteSale());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    public Command getCommand(String name) {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        }catch (IllegalArgumentException | NullPointerException e){
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
