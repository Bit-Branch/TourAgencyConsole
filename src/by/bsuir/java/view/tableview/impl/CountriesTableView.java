package by.bsuir.java.view.tableview.impl;

import by.bsuir.java.entity.Client;
import by.bsuir.java.entity.Country;
import by.bsuir.java.view.tableview.TableView;

import java.util.List;

public class CountriesTableView implements TableView<Country> {

    @Override
    public String outputTable(List<Country> clients) {

        String sizes = "|%-10s|%-20s|%n";
        StringBuilder sb = new StringBuilder(String.format(sizes, "ID", "Name"));
        if (clients != null) {
            for (Country client : clients) {
                Long id = client.getId();
                String name = client.getName();
                sb.append(String.format(sizes, id,name ));
            }
        }
        return sb.toString();
    }
}
