package by.bsuir.java.dao.converter.impl;

import by.bsuir.java.dao.converter.Converter;
import by.bsuir.java.dao.converter.exception.ConverterException;
import by.bsuir.java.entity.Employee;

public class EmployeeConverter implements Converter<Employee> {

    @Override
    public Employee getFromString(String str) throws ConverterException {

        if (isNull(str)) {
            throw new ConverterException("Unable to get Expense from string: string has null value");
        }
        String[] splits = str.split("~");
        Long id = Long.valueOf(splits[0].replace("id: ", ""));
        String surname = splits[1].replace("surname: ", "");
        String name = splits[2].replace("name: ", "");
        String patronymic = splits[3].replace("patronymic: ", "");
        String phone = splits[4].replace("phone: ", "");
        Long idAccount = Long.valueOf(splits[5].replace("idAccount: ", ""));
        return new Employee(id, surname, name, patronymic, phone, idAccount);
    }

    @Override
    public String convertToString(Employee obj) throws ConverterException {
        if (isNull(obj)) {
            throw new ConverterException("Unable to convert Expense to string: expense has null value");
        }
        return "id: " + obj.getId() + "~" +
                "surname: " + obj.getSurname() + "~" +
                "name: " + obj.getName() + "~" +
                "patronymic: " + obj.getPatronymic() + "~" +
                "phone: " + obj.getPhone() + "~" +
                "idAccount: " + obj.getAccountID() + "\n";
    }
}
