package by.bsuir.java.dao.converter.impl;

import by.bsuir.java.dao.converter.Converter;
import by.bsuir.java.dao.converter.exception.ConverterException;
import by.bsuir.java.entity.Client;
import by.bsuir.java.entity.Tour;

import java.sql.Timestamp;

public class TourConverter implements Converter<Tour> {

    @Override
    public Tour getFromString(String str) throws ConverterException {

        if (isNull(str)) {
            throw new ConverterException("Unable to get Expense from string: string has null value");
        }



        String[] splits = str.split("~");
        Long id = Long.valueOf(splits[0].replace("id: ", ""));
        String name = splits[1].replace("name: ", "");
        double price = Double.parseDouble(splits[2].replace("price: ", ""));
        Timestamp departureTime = Timestamp.valueOf(splits[3].replace("departureTime: ", ""));
        String departureCity = splits[4].replace("departureCity: ", "");
        int adultsCount = Integer.parseInt(splits[5].replace("adultsCount: ", ""));
        int childrenCount = Integer.parseInt(splits[6].replace("childrenCount: ", ""));
        int daysCount = Integer.parseInt(splits[7].replace("daysCount: ", ""));
        int nightsCount = Integer.parseInt(splits[8].replace("nightsCount: ", ""));
        Long idHotel = Long.valueOf(splits[9].replace("idHotel: ", ""));
        Long idDiscount = Long.valueOf(splits[10].replace("idDiscount: ", ""));
        return new Tour(id, name,price,departureTime,departureCity,adultsCount,childrenCount,daysCount,nightsCount,idHotel,idDiscount);
    }

    @Override
    public String convertToString(Tour obj) throws ConverterException {
        if (isNull(obj)) {
            throw new ConverterException("Unable to convert Expense to string: expense has null value");
        }
        return "id: " + obj.getId() + "~" +
                "name: " + obj.getName() + "~" +
                "price: " + obj.getPrice() + "~" +
                "departureTime: " + obj.getDepartureTime() + "~" +
                "departureCity: " + obj.getDepartureCity() + "~" +
                "adultsCount: " + obj.getChildrenCount() + "~" +
                "childrenCount: " + obj.getChildrenCount() + "~" +
                "daysCount: " + obj.getDaysCount() + "~" +
                "nightsCount: " + obj.getNightsCount() + "~" +
                "idHotel: " + obj.getHotelID() + "~" +
                "idDiscount: " + obj.getDiscountID() + "\n";
    }
}