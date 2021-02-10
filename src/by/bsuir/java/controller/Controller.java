package by.bsuir.java.controller;

import by.bsuir.java.controller.command.Command;
import by.bsuir.java.controller.command.CommandProvider;
import by.bsuir.java.controller.command.exception.CommandException;
import by.bsuir.java.controller.exception.ControllerException;


public class Controller{

    private final CommandProvider provider = new CommandProvider();

    public String executeTask(String request) throws ControllerException {
        String error = "Can't execute task: ";
        if (request == null){
            throw new ControllerException(error + "wrong request");
        }
        String command;
        Command executionCommand;
        try {
            char paramDelimiter = '$';
            command = request.substring(0, request.indexOf(paramDelimiter));
            executionCommand = provider.getCommand(command);

            String response;
            response = executionCommand.execute(request);
            return response;
        } catch (CommandException e) {
            String message = "command error";
            throw new ControllerException(error + message, e);
        }
    }
}
