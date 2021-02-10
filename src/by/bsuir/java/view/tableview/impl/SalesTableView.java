package by.bsuir.java.view.tableview.impl;

import by.bsuir.java.entity.Return;
import by.bsuir.java.entity.Sale;
import by.bsuir.java.view.tableview.TableView;

import java.sql.Timestamp;
import java.util.List;

public class SalesTableView implements TableView<Sale> {

    @Override
    public String outputTable(List<Sale> clients) {

        String sizes = "|%-10s|%-15s|%-5s|%-10s|%-10s|%-10s|%n";
        StringBuilder sb = new StringBuilder(String.format(sizes, "ID", "Sale time", "Count", "Client ID", "Employee ID", "Tour ID"));
        if (clients != null) {
            for (Sale client : clients) {

                Long id = client.getId();
                Timestamp saleTime = client.getSaleTime();
                int count = client.getCount();
                long clientID = client.getClientID();
                long employeeID = client.getEmployeeID();
                long tourID = client.getTourID();
                sb.append(String.format(sizes, id, saleTime,count,clientID,employeeID,tourID));
            }
        }
        return sb.toString();
    }
}
