package by.bsuir.java.controller.command.translator.impl;

import by.bsuir.java.controller.command.translator.RequestTranslator;
import by.bsuir.java.controller.command.translator.exception.RequestTranslationException;
import by.bsuir.java.entity.Client;
import by.bsuir.java.entity.Employee;

public class EmployeeRequestTranslator implements RequestTranslator<Employee> {

    private static final String SURNAME = "SURNAME";
    private static final String NAME = "NAME";
    private static final String PATRONYMIC = "PATRONYMIC";
    private static final String PHONE = "PHONE";
    private static final String ACCOUNT_ID = "ACCOUNT_ID";


    @Override
    public Employee translate(String request) throws RequestTranslationException {
        if (request == null) {
            throw new RequestTranslationException("Request has null value.");
        }

        String surname = null;
        String name = null;
        String patronymic = null;
        String[] args = request.split("[$&]");
        for (String arg : args) {
            int beginIndex = arg.indexOf('=');
            if (beginIndex > -1){
                String argName = arg.substring(0, beginIndex);
                String argValue = arg.substring(beginIndex + 1);
                switch (argName.toUpperCase()) {
                    case SURNAME:
                        surname = argValue;
                        break;
                    case NAME:
                        name = argValue;
                        break;
                    case PATRONYMIC:
                        patronymic = argValue;
                        break;
                }
            }
        }
        return new Employee(surname,name,patronymic);
    }

    @Override
    public Employee translateToObject(String request) throws RequestTranslationException {
        if (request == null) {
            throw new RequestTranslationException("Request has null value.");
        }
        String surname = null;
        String name = null;
        String patronymic = null;
        String passport = null;
        String phone = null;
        long accountID = -1;
        String[] args = request.split("[$&]");
        for (String arg : args) {
            int beginIndex = arg.indexOf('=');
            if (beginIndex > -1){
                String argName = arg.substring(0, beginIndex);
                String argValue = arg.substring(beginIndex + 1);
                switch (argName.toUpperCase()) {
                    case SURNAME:
                        surname = argValue;
                        break;
                    case NAME:
                        name = argValue;
                        break;
                    case PATRONYMIC:
                        patronymic = argValue;
                        break;
                    case PHONE:
                        phone = argValue;
                        break;
                    case ACCOUNT_ID:
                        accountID = Long.parseLong(argValue);
                        break;
                }
            }
        }
        return new Employee(surname,name,patronymic,phone,accountID);
    }
}
