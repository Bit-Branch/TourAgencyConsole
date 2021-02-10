package by.bsuir.java.dao.converter;


import by.bsuir.java.dao.converter.exception.ConverterException;
import by.bsuir.java.dao.validator.DAOValidator;

public interface Converter<T> extends DAOValidator {
    T getFromString(String str) throws ConverterException;
    String convertToString(T obj) throws ConverterException;
}
