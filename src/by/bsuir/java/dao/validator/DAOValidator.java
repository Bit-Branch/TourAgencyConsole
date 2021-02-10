package by.bsuir.java.dao.validator;

public interface DAOValidator {
    default boolean isNull(Object object){
        return (object == null);
    }
}
