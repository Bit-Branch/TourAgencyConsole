package by.bsuir.java.controller.command;


import by.bsuir.java.controller.command.exception.CommandException;

public interface Command {
    String execute(String request) throws CommandException;
}
