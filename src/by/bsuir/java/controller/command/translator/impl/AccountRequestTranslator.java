package by.bsuir.java.controller.command.translator.impl;

import by.bsuir.java.controller.command.translator.RequestTranslator;
import by.bsuir.java.controller.command.translator.exception.RequestTranslationException;
import by.bsuir.java.entity.Account;
import by.bsuir.java.entity.Role;

public class AccountRequestTranslator implements RequestTranslator<Account> {

    private static final String LOGIN = "LOGIN";
    private static final String PASSWORD = "PASSWORD";
    private static final String ROLE = "ROLE";

    @Override
    public Account translate(String request) throws RequestTranslationException {
        if (request == null) {
            throw new RequestTranslationException("Request has null value.");
        }

        String login = null;
        String password = null;
        Role role = null;
        String[] args = request.split("[$&]");
        for (String arg : args) {
            int beginIndex = arg.indexOf('=');
            if (beginIndex > -1){
                String argName = arg.substring(0, beginIndex);
                String argValue = arg.substring(beginIndex + 1);
                switch (argName.toUpperCase()) {
                    case LOGIN:
                        login = argValue;
                        break;
                    case PASSWORD:
                        password = argValue;
                        break;
                    case ROLE:
                        role = Role.valueOf(argValue);
                        break;
                }
            }
        }
        return new Account(login, password,role);
    }

    @Override
    public Account translateToObject(String request) throws RequestTranslationException {
        if (request == null) {
            throw new RequestTranslationException("Request has null value.");
        }
        String login = null;
        String password = null;
        Role role = null;
        String[] args = request.split("[$&]");
        for (String arg : args) {
            int beginIndex = arg.indexOf('=');
            if (beginIndex > -1){
                String argName = arg.substring(0, beginIndex);
                String argValue = arg.substring(beginIndex + 1);
                switch (argName.toUpperCase()) {
                    case ROLE:
                        role = Role.valueOf(argValue);
                        break;
                    case LOGIN:
                        login = argValue;
                        break;
                    case PASSWORD:
                        password = argValue;
                        break;
                }
            }
        }
        return new Account(login, password,role);
    }
}
