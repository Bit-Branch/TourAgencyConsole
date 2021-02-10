package by.bsuir.java.controller.command.translator.impl;

import by.bsuir.java.controller.command.translator.RequestTranslator;
import by.bsuir.java.controller.command.translator.exception.RequestTranslationException;
import by.bsuir.java.entity.Tour;

import java.sql.Timestamp;

public class TourRequestTranslator implements RequestTranslator<Tour> {

    private static final String NAME = "NAME";
    private static final String PRICE = "PRICE";
    private static final String DEPARTURE_TIME = "DEPARTURE_TIME";
    private static final String DEPARTURE_CITY = "DEPARTURE_CITY";
    private static final String ADULTS_COUNT = "ADULTS_COUNT";
    private static final String CHILDREN_COUNT = "CHILDREN_COUNT";
    private static final String DAYS_COUNT = "DAYS_COUNT";
    private static final String NIGHTS_COUNT = "NIGHTS_COUNT";
    private static final String HOTEL_ID = "HOTEL_ID";
    private static final String DISCOUNT_ID = "DISCOUNT_ID";


    @Override
    public Tour translate(String request) throws RequestTranslationException {
        if (request == null) {
            throw new RequestTranslationException("Request has null value.");
        }

        String name = null;
         double price = 0;
         Timestamp departureTime = null;
         String departureCity = null;
         int adultsCount = 0;
         int childrenCount = 0;
         int daysCount = 0;
         int nightsCount = 0;
         long hotelID = -1;
         long discountID = -1;

        String[] args = request.split("[$&]");
        for (String arg : args) {
            int beginIndex = arg.indexOf('=');
            if (beginIndex > -1){
                String argName = arg.substring(0, beginIndex);
                String argValue = arg.substring(beginIndex + 1);
                switch (argName.toUpperCase()) {
                    case DEPARTURE_TIME:
                        departureTime = Timestamp.valueOf(argValue);
                        break;
                    case ADULTS_COUNT:
                        adultsCount = Integer.parseInt(argValue);
                        break;
                    case CHILDREN_COUNT:
                        childrenCount = Integer.parseInt(argValue);
                        break;
                    case DAYS_COUNT:
                        daysCount = Integer.parseInt(argValue);
                        break;
                    case NIGHTS_COUNT:
                        nightsCount = Integer.parseInt(argValue);
                        break;
                    case PRICE:
                        price = Double.parseDouble(argValue);
                        break;
                    case HOTEL_ID:
                        hotelID = Long.parseLong(argValue);
                        break;
                    case DISCOUNT_ID:
                        discountID = Long.parseLong(argValue);
                        break;
                    case DEPARTURE_CITY:
                        departureCity = argValue;
                        break;
                }
            }
        }
        return new Tour( name,  price,  departureTime,  departureCity,  daysCount,  nightsCount);
    }

    @Override
    public Tour translateToObject(String request) throws RequestTranslationException {
        if (request == null) {
            throw new RequestTranslationException("Request has null value.");
        }
        String name = null;
        double price = 0;
        Timestamp departureTime = null;
        String departureCity = null;
        int adultsCount = 0;
        int childrenCount = 0;
        int daysCount = 0;
        int nightsCount = 0;
        long hotelID = -1;
        long discountID = -1;
        String[] args = request.split("[$&]");
        for (String arg : args) {
            int beginIndex = arg.indexOf('=');
            if (beginIndex > -1){
                String argName = arg.substring(0, beginIndex);
                String argValue = arg.substring(beginIndex + 1);
                switch (argName.toUpperCase()) {
                    case DEPARTURE_TIME:
                        departureTime = Timestamp.valueOf(argValue);
                        break;
                    case ADULTS_COUNT:
                        adultsCount = Integer.parseInt(argValue);
                        break;
                    case CHILDREN_COUNT:
                        childrenCount = Integer.parseInt(argValue);
                        break;
                    case DAYS_COUNT:
                        daysCount = Integer.parseInt(argValue);
                        break;
                    case NIGHTS_COUNT:
                        nightsCount = Integer.parseInt(argValue);
                        break;
                    case PRICE:
                        price = Double.parseDouble(argValue);
                        break;
                    case HOTEL_ID:
                        hotelID = Long.parseLong(argValue);
                        break;
                    case DISCOUNT_ID:
                        discountID = Long.parseLong(argValue);
                        break;
                    case DEPARTURE_CITY:
                        departureCity = argValue;
                        break;
                }
            }
        }
        return new Tour(  name,  price,  departureTime,  departureCity,  adultsCount,  childrenCount,  daysCount,  nightsCount,  hotelID,  discountID);
    }
}
