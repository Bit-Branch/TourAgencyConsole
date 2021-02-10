package by.bsuir.java.view.tableview.impl;

import by.bsuir.java.entity.Account;
import by.bsuir.java.entity.Role;
import by.bsuir.java.view.tableview.TableView;

import java.util.List;

public class AccountsTableView implements TableView<Account> {
    @Override
    public String outputTable(List<Account> users) {
        String sizes = "|%-10s|%-20s|%-15s|%-10s|%n";
        StringBuilder sb = new StringBuilder(String.format(sizes, "ID","Login", "Password", "Role"));
        if (users != null) {
            for (Account user : users) {
                Long id = user.getId();
                String login = user.getLogin();
                String password = user.getPassword();
                Role userType = user.getRole();
                sb.append(String.format(sizes, id, login, password, userType));
            }
        }
        return sb.toString();
    }
}
