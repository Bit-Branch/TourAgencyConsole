package by.bsuir.java.view.tableview.impl;

import by.bsuir.java.entity.Client;
import by.bsuir.java.entity.Discount;
import by.bsuir.java.view.tableview.TableView;

import java.util.List;

public class DiscountsTableView implements TableView<Discount> {

    @Override
    public String outputTable(List<Discount> clients) {

        String sizes = "|%-10s|%-20s|%-10s|%n";
        StringBuilder sb = new StringBuilder(String.format(sizes, "ID",  "Name", "Size"));
        if (clients != null) {
            for (Discount client : clients) {
                Long id = client.getId();
                String name = client.getName();
                Double size = client.getSize();
                sb.append(String.format(sizes, id, name, size));
            }
        }
        return sb.toString();
    }
}
