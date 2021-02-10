package by.bsuir.java.controller.command.translator;


import by.bsuir.java.controller.command.translator.exception.RequestTranslationException;

public interface RequestTranslator<T> {
    T translate(String request) throws RequestTranslationException;
    T translateToObject(String request) throws RequestTranslationException;
}
