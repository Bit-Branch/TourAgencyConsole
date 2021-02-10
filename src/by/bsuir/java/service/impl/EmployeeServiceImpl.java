package by.bsuir.java.service.impl;

import by.bsuir.java.dao.EmployeeDAO;
import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.dao.factory.DAOFactory;
import by.bsuir.java.entity.Country;
import by.bsuir.java.entity.Employee;
import by.bsuir.java.service.EmployeeService;
import by.bsuir.java.service.exception.ServiceException;
import by.bsuir.java.service.validator.ServiceValidator;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService, ServiceValidator {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();

    @Override
    public List<Employee> getAll(Integer idAccount) throws ServiceException {
        try{
            return employeeDAO.getAllByAccountId(idAccount);
        }catch (DAOException ex){
            String error = "Can not get all records in ExpenseServiceImpl: " + ex.getMessage();
            throw new ServiceException(error);
        }
    }

    @Override
    public List<Employee> getAll() throws ServiceException {
        try{
            return employeeDAO.getAll();
        }catch (DAOException ex){
            String error = "Can not get all records in ExpenseServiceImpl: " + ex.getMessage();
            throw new ServiceException(error);
        }
    }

    @Override
    public Employee getById(Integer id) throws ServiceException {
        String error= "Unable to get expense by id : ";
        if (isNull(id)){
            throw new ServiceException(error + "id has null value");
        }
        try{
            return employeeDAO.getById(id);
        }catch (DAOException ex){
            throw new ServiceException(error + ex.getMessage());
        }
    }

    @Override
    public Long create(Employee obj) throws ServiceException {
        String error= "Unable to add expense: ";
        if (isNull(obj)){
            throw new ServiceException(error + "expense has null value");
        }
        try{
            Integer id = getAll().size();
            obj.setId(id);
            EmployeeService clientService = new EmployeeServiceImpl();
            Employee client = clientService.getById((int)obj.getAccountID());
            if (client == null){
                client = new Employee();
                client.setId(obj.getId());
            }
            client.setSurname(obj.getSurname());
            client.setName(obj.getName());
            client.setPatronymic(obj.getPatronymic());
            client.setPhone(obj.getPhone());
            client.setAccountID(obj.getAccountID());
            clientService.update(client);
            return employeeDAO.add(obj);
        }catch (DAOException ex){
            throw new ServiceException(error + ex.getMessage());
        }
    }

    @Override
    public void update(Employee obj) throws ServiceException {
        String error= "Unable to update expense: ";
        if (isNull(obj)){
            throw new ServiceException(error + "object has null value");
        }
        try{
            employeeDAO.update(obj);
        }catch (DAOException ex){
            throw new ServiceException(error + ex.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws ServiceException {
        String error= "Unable to delete expense: ";
        if (isNull(id)){
            throw new ServiceException(error + "object has null value");
        }
        try{
            employeeDAO.delete(id);
        }catch (DAOException ex){
            throw new ServiceException();
        }
    }
}
