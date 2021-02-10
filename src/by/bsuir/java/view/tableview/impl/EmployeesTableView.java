package by.bsuir.java.view.tableview.impl;

import by.bsuir.java.entity.Client;
import by.bsuir.java.entity.Employee;
import by.bsuir.java.view.tableview.TableView;

import java.util.List;

public class EmployeesTableView implements TableView<Employee> {

    @Override
    public String outputTable(List<Employee> clients) {

        String sizes = "|%-10s|%-20s|%-20s|%-20s|%-10s|%-10s|%n";
        StringBuilder sb = new StringBuilder(String.format(sizes, "ID", "Surname", "Name", "Patronymic", "Phone", "Account ID"));
        if (clients != null) {
            for (Employee client : clients) {
                Long id = client.getId();
                String surname = client.getSurname();
                String name = client.getName();
                String patronymic = client.getPatronymic();
                String phone = client.getPhone();
                Long accountID = client.getAccountID();
                sb.append(String.format(sizes, id, surname, name, patronymic, phone, accountID));
            }
        }
        return sb.toString();
    }
}
