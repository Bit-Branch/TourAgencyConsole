package by.bsuir.java.controller.command.translator.impl;

import by.bsuir.java.controller.command.translator.RequestTranslator;
import by.bsuir.java.controller.command.translator.exception.RequestTranslationException;
import by.bsuir.java.entity.Client;
import by.bsuir.java.entity.Country;

public class CountryRequestTranslator implements RequestTranslator<Country> {

    private static final String NAME = "NAME";


    @Override
    public Country translate(String request) throws RequestTranslationException {
        if (request == null) {
            throw new RequestTranslationException("Request has null value.");
        }


        String name = null;

        String[] args = request.split("[$&]");
        for (String arg : args) {
            int beginIndex = arg.indexOf('=');
            if (beginIndex > -1){
                String argName = arg.substring(0, beginIndex);
                String argValue = arg.substring(beginIndex + 1);
                switch (argName.toUpperCase()) {
                    case NAME:
                        name = argValue;
                        break;
                }
            }
        }
        return new Country(name);
    }

    @Override
    public Country translateToObject(String request) throws RequestTranslationException {
        if (request == null) {
            throw new RequestTranslationException("Request has null value.");
        }
        String name = null;

        String[] args = request.split("[$&]");
        for (String arg : args) {
            int beginIndex = arg.indexOf('=');
            if (beginIndex > -1){
                String argName = arg.substring(0, beginIndex);
                String argValue = arg.substring(beginIndex + 1);
                switch (argName.toUpperCase()) {
                    case NAME:
                        name = argValue;
                        break;

                }
            }
        }
        return new Country(name);
    }
}
