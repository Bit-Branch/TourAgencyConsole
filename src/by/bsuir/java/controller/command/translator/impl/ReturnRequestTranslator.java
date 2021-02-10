package by.bsuir.java.controller.command.translator.impl;

import by.bsuir.java.controller.command.translator.RequestTranslator;
import by.bsuir.java.controller.command.translator.exception.RequestTranslationException;
import by.bsuir.java.entity.Client;
import by.bsuir.java.entity.Return;

import java.sql.Timestamp;

public class ReturnRequestTranslator implements RequestTranslator<Return> {

    private static final String SALE_TIME = "SALE_TIME";
    private static final String COUNT = "COUNT";
    private static final String REASON = "REASON";
    private static final String CLIENT_ID = "CLIENT_ID";
    private static final String EMPLOYEE_ID = "EMPLOYEE_ID";
    private static final String TOUR_ID = "TOUR_ID";


    @Override
    public Return translate(String request) throws RequestTranslationException {
        if (request == null) {
            throw new RequestTranslationException("Request has null value.");
        }

        Timestamp saleTime = null;
        int count = 0;
        String reason = null;
        long clientID = -1;
        long employeeID = -1;
        long tourID = -1;
        String[] args = request.split("[$&]");
        for (String arg : args) {
            int beginIndex = arg.indexOf('=');
            if (beginIndex > -1){
                String argName = arg.substring(0, beginIndex);
                String argValue = arg.substring(beginIndex + 1);
                switch (argName.toUpperCase()) {
                    case SALE_TIME:
                        saleTime = Timestamp.valueOf(argValue);
                        break;
                    case COUNT:
                        count = Integer.parseInt(argValue);
                        break;
                    case REASON:
                        reason = argValue;
                        break;
                    case CLIENT_ID:
                        clientID = Long.parseLong(argValue);
                        break;
                    case EMPLOYEE_ID:
                        employeeID = Long.parseLong(argValue);
                        break;
                    case TOUR_ID:
                        tourID = Long.parseLong(argValue);
                        break;
                }
            }
        }
        return new Return(saleTime, count, reason);
    }

    @Override
    public Return translateToObject(String request) throws RequestTranslationException {
        if (request == null) {
            throw new RequestTranslationException("Request has null value.");
        }
        Timestamp saleTime = null;
        int count = 0;
        String reason = null;
        long clientID = -1;
        long employeeID = -1;
        long tourID = -1;
        String[] args = request.split("[$&]");
        for (String arg : args) {
            int beginIndex = arg.indexOf('=');
            if (beginIndex > -1){
                String argName = arg.substring(0, beginIndex);
                String argValue = arg.substring(beginIndex + 1);
                switch (argName.toUpperCase()) {
                    case SALE_TIME:
                        saleTime = Timestamp.valueOf(argValue);
                        break;
                    case COUNT:
                        count = Integer.parseInt(argValue);
                        break;
                    case REASON:
                        reason = argValue;
                        break;
                    case CLIENT_ID:
                        clientID = Long.parseLong(argValue);
                        break;
                    case EMPLOYEE_ID:
                        employeeID = Long.parseLong(argValue);
                        break;
                    case TOUR_ID:
                        tourID = Long.parseLong(argValue);
                        break;
                }
            }
        }
        return new Return( saleTime,  count,  reason,  clientID,  employeeID,  tourID);
    }
}
