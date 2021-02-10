package by.bsuir.java.controller.command.translator.impl;

import by.bsuir.java.controller.command.translator.RequestTranslator;
import by.bsuir.java.controller.command.translator.exception.RequestTranslationException;
import by.bsuir.java.entity.Client;
import by.bsuir.java.entity.Hotel;

public class HotelRequestTranslator implements RequestTranslator<Hotel> {

    private static final String NAME = "NAME";
    private static final String TYPE = "TYPE";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String COUNTRY_ID = "COUNTRY_ID";


    @Override
    public Hotel translate(String request) throws RequestTranslationException {
        if (request == null) {
            throw new RequestTranslationException("Request has null value.");
        }

        String type = null;
        String name = null;
        String description = null;
        String[] args = request.split("[$&]");
        for (String arg : args) {
            int beginIndex = arg.indexOf('=');
            if (beginIndex > -1){
                String argName = arg.substring(0, beginIndex);
                String argValue = arg.substring(beginIndex + 1);
                switch (argName.toUpperCase()) {
                    case TYPE:
                        type = argValue;
                        break;
                    case NAME:
                        name = argValue;
                        break;
                    case DESCRIPTION:
                        description = argValue;
                        break;
                }
            }
        }
        return new Hotel(name,type);
    }

    @Override
    public Hotel translateToObject(String request) throws RequestTranslationException {
        if (request == null) {
            throw new RequestTranslationException("Request has null value.");
        }
        String type = null;
        String name = null;
        String description = null;
        long countryID = -1;
        String[] args = request.split("[$&]");
        for (String arg : args) {
            int beginIndex = arg.indexOf('=');
            if (beginIndex > -1){
                String argName = arg.substring(0, beginIndex);
                String argValue = arg.substring(beginIndex + 1);
                switch (argName.toUpperCase()) {
                    case TYPE:
                        type = argValue;
                        break;
                    case NAME:
                        name = argValue;
                        break;
                    case DESCRIPTION:
                        description = argValue;
                        break;
                    case COUNTRY_ID:
                        countryID = Long.parseLong(argValue);
                        break;
                }
            }
        }
        return new Hotel(name,type,description,countryID);
    }
}
