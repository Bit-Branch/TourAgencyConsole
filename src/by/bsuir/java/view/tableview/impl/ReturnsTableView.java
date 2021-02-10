package by.bsuir.java.view.tableview.impl;

import by.bsuir.java.entity.Client;
import by.bsuir.java.entity.Return;
import by.bsuir.java.view.tableview.TableView;

import java.sql.Timestamp;
import java.util.List;

public class ReturnsTableView implements TableView<Return> {

    @Override
    public String outputTable(List<Return> clients) {

        String sizes = "|%-10s|%-15s|%-5s|%-40s|%-10s|%-10s|%-10s|%n";
        StringBuilder sb = new StringBuilder(String.format(sizes, "ID", "Sale time", "Count", "Reason", "Client ID", "Employee ID", "Tour ID"));
        if (clients != null) {
            for (Return client : clients) {

                Long id = client.getId();
                Timestamp saleTime = client.getSaleTime();
                int count = client.getCount();
                String reason = client.getReason();
                long clientID = client.getClientID();
                long employeeID = client.getEmployeeID();
                long tourID = client.getTourID();
                sb.append(String.format(sizes, id, saleTime,count,reason,clientID,employeeID,tourID));
            }
        }
        return sb.toString();
    }
}
