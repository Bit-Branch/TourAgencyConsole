package by.bsuir.java.dao.converter.impl;

import by.bsuir.java.dao.converter.Converter;
import by.bsuir.java.dao.converter.exception.ConverterException;
import by.bsuir.java.entity.Client;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static java.util.Objects.isNull;

public class ClientConverter implements Converter<Client> {

    @Override
    public Client getFromString(String str) throws ConverterException {

        if (isNull(str)) {
            throw new ConverterException("Unable to get Expense from string: string has null value");
        }
        String[] splits = str.split("~");
        Long id = Long.valueOf(splits[0].replace("id: ", ""));
        String surname = splits[1].replace("surname: ", "");
        String name = splits[2].replace("name: ", "");
        String patronymic = splits[3].replace("patronymic: ", "");
        String passport = splits[4].replace("passport: ", "");
        String email = splits[5].replace("email: ", "");
        String phone = splits[6].replace("phone: ", "");
        Long idAccount = Long.valueOf(splits[7].replace("idAccount: ", ""));
        return new Client(id, surname, name, patronymic, passport, email, phone, idAccount);
    }

    @Override
    public String convertToString(Client obj) throws ConverterException {
        if (isNull(obj)) {
            throw new ConverterException("Unable to convert Expense to string: expense has null value");
        }
        return "id: " + obj.getId() + "~" +
                "surname: " + obj.getSurname() + "~" +
                "name: " + obj.getName() + "~" +
                "patronymic: " + obj.getPatronymic() + "~" +
                "passport: " + obj.getPassport() + "~" +
                "email: " + obj.getEmail() + "~" +
                "phone: " + obj.getPhone() + "~" +
                "idAccount: " + obj.getAccountID() + "\n";
    }
}
