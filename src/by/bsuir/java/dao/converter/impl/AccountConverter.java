package by.bsuir.java.dao.converter.impl;


import by.bsuir.java.dao.converter.Converter;
import by.bsuir.java.dao.converter.exception.ConverterException;
import by.bsuir.java.entity.Account;
import by.bsuir.java.entity.Role;

public class AccountConverter implements Converter<Account> {

    @Override
    public Account getFromString(String str) throws ConverterException {
        if (isNull(str)){
            throw new ConverterException("Unable to get User from string: string has null value");
        }
        String[] splits = str.split("~");
        Integer id = Integer.valueOf(splits[0].replace("id: ",""));
        String login = splits[1].replace("login: ", "");
        String password = splits[2].replace("password: ", "");
        Role role = Role.valueOf(splits[3].replace("role: ",""));
        return new Account(id,login,password,role);
    }

    @Override
    public String convertToString(Account obj) throws ConverterException {
        if (isNull(obj)){
            throw new ConverterException("Unable to convert User to string: user has null value");
        }
        return  "id: " + obj.getId() + "~" +
                "login: " + obj.getLogin() + "~" +
                "password: " + obj.getPassword() + "~" +
                "role: " + obj.getRole() + "\n";
    }
}
