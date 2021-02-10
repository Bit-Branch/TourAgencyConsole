package by.bsuir.java.dao.converter.impl;

import by.bsuir.java.dao.converter.Converter;
import by.bsuir.java.dao.converter.exception.ConverterException;
import by.bsuir.java.entity.Return;

import java.sql.Timestamp;

public class ReturnConverter implements Converter<Return> {

    @Override
    public Return getFromString(String str) throws ConverterException {
        if (isNull(str)) {
            throw new ConverterException("Unable to get Expense from string: string has null value");
        }


        String[] splits = str.split("~");
        Long id = Long.valueOf(splits[0].replace("id: ", ""));
        Timestamp saleTime = Timestamp.valueOf(splits[1].replace("saleTime: ", ""));
        Integer count = Integer.valueOf(splits[2].replace("count: ", ""));
        String reason = splits[3].replace("reason: ", "");
        Long idClient = Long.valueOf(splits[4].replace("idClient: ", ""));
        Long idEmployee = Long.valueOf(splits[5].replace("idEmployee: ", ""));
        Long idTour = Long.valueOf(splits[6].replace("idTour: ", ""));
        return new Return(id, saleTime, count, reason, idClient, idEmployee, idTour);
    }

    @Override
    public String convertToString(Return obj) throws ConverterException {
        if (isNull(obj)) {
            throw new ConverterException("Unable to convert Expense to string: expense has null value");
        }
        return "id: " + obj.getId() + "~" +
                "saleTime: " + obj.getSaleTime() + "~" +
                "count: " + obj.getCount() + "~" +
                "reason: " + obj.getReason() + "~" +
                "idClient: " + obj.getClientID() + "~" +
                "idEmployee: " + obj.getEmployeeID() + "~" +
                "idTour: " + obj.getTourID() + "\n";
    }
}
