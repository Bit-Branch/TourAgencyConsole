package by.bsuir.java.dao.converter.impl;

import by.bsuir.java.dao.converter.Converter;
import by.bsuir.java.dao.converter.exception.ConverterException;
import by.bsuir.java.entity.Hotel;

public class HotelConverter implements Converter<Hotel> {

    @Override
    public Hotel getFromString(String str) throws ConverterException {

        if (isNull(str)) {
            throw new ConverterException("Unable to get Expense from string: string has null value");
        }
        String[] splits = str.split("~");
        Long id = Long.valueOf(splits[0].replace("id: ", ""));
        String name = splits[1].replace("name: ", "");
        String type = splits[2].replace("type: ", "");
        String description = splits[3].replace("description: ", "");
        Long idCountry = Long.valueOf(splits[4].replace("idCountry: ", ""));
        return new Hotel(id,  name, type, description, idCountry);
    }

    @Override
    public String convertToString(Hotel obj) throws ConverterException {
        if (isNull(obj)) {
            throw new ConverterException("Unable to convert Expense to string: expense has null value");
        }
        return "id: " + obj.getId() + "~" +
                "name: " + obj.getName() + "~" +
                "type: " + obj.getType() + "~" +
                "description: " + obj.getDescription() + "~" +
                "idCountry: " + obj.getCountryID() + "\n";
    }
}
