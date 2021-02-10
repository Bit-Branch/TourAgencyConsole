package by.bsuir.java.dao.converter.impl;

import by.bsuir.java.dao.converter.Converter;
import by.bsuir.java.dao.converter.exception.ConverterException;
import by.bsuir.java.entity.Client;
import by.bsuir.java.entity.Discount;

public class DiscountConverter implements Converter<Discount> {

    @Override
    public Discount getFromString(String str) throws ConverterException {

        if (isNull(str)) {
            throw new ConverterException("Unable to get Expense from string: string has null value");
        }
        String[] splits = str.split("~");
        Long id = Long.valueOf(splits[0].replace("id: ", ""));
        String name = splits[1].replace("name: ", "");
        double size = Double.parseDouble(splits[2].replace("size: ", ""));
        return new Discount(id, name, size);
    }

    @Override
    public String convertToString(Discount obj) throws ConverterException {
        if (isNull(obj)) {
            throw new ConverterException("Unable to convert Expense to string: expense has null value");
        }
        return "id: " + obj.getId() + "~" +
                "name: " + obj.getName() + "~" +
                "size: " + obj.getSize() + "\n";
    }
}
