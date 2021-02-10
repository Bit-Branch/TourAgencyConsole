package by.bsuir.java.view.tableview.impl;

import by.bsuir.java.entity.Client;
import by.bsuir.java.view.tableview.TableView;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ClientsTableView implements TableView<Client> {

    @Override
    public String outputTable(List<Client> clients) {

        String sizes = "|%-10s|%-20s|%-20s|%-20s|%-10s|%-20s|%-10s|%-10s|%n";
        StringBuilder sb = new StringBuilder(String.format(sizes, "ID", "Surname", "Name", "Patronymic", "Passport", "Email", "Phone", "Account ID"));
        if (clients != null) {
            for (Client client : clients) {
                Long id = client.getId();
                String surname = client.getSurname();
                String name = client.getName();
                String patronymic = client.getPatronymic();
                String passport = client.getPassport();
                String email = client.getEmail();
                String phone = client.getPhone();
                Long accountID = client.getAccountID();
                sb.append(String.format(sizes, id, surname, name, patronymic, passport, email, phone, accountID));
            }
        }
        return sb.toString();
    }
}
