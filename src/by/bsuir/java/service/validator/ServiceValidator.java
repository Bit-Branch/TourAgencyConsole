package by.bsuir.java.service.validator;

public interface ServiceValidator {
    default boolean isNull(Object object){
        return (object == null);
    }
}
