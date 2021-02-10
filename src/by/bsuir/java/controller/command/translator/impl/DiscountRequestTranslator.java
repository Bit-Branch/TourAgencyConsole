package by.bsuir.java.controller.command.translator.impl;

import by.bsuir.java.controller.command.translator.RequestTranslator;
import by.bsuir.java.controller.command.translator.exception.RequestTranslationException;
import by.bsuir.java.entity.Client;
import by.bsuir.java.entity.Discount;

public class DiscountRequestTranslator implements RequestTranslator<Discount> {

    private static final String NAME = "NAME";
    private static final String SIZE = "SIZE";


    @Override
    public Discount translate(String request) throws RequestTranslationException {
        if (request == null) {
            throw new RequestTranslationException("Request has null value.");
        }

        double size = 0;
        String name = null;
        String[] args = request.split("[$&]");
        for (String arg : args) {
            int beginIndex = arg.indexOf('=');
            if (beginIndex > -1){
                String argName = arg.substring(0, beginIndex);
                String argValue = arg.substring(beginIndex + 1);
                switch (argName.toUpperCase()) {
                    case SIZE:
                        size = Double.parseDouble(argValue);
                        break;
                    case NAME:
                        name = argValue;
                        break;
                }
            }
        }
        return new Discount(name,size);
    }

    @Override
    public Discount translateToObject(String request) throws RequestTranslationException {
        if (request == null) {
            throw new RequestTranslationException("Request has null value.");
        }
        double size = 0;
        String name = null;
        String[] args = request.split("[$&]");
        for (String arg : args) {
            int beginIndex = arg.indexOf('=');
            if (beginIndex > -1){
                String argName = arg.substring(0, beginIndex);
                String argValue = arg.substring(beginIndex + 1);
                switch (argName.toUpperCase()) {
                    case SIZE:
                        size = Double.parseDouble(argValue);
                        break;
                    case NAME:
                        name = argValue;
                        break;
                }
            }
        }
        return new Discount(name,size);
    }
}
