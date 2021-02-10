package by.bsuir.java.view.tableview.impl;

import by.bsuir.java.entity.Client;
import by.bsuir.java.entity.Hotel;
import by.bsuir.java.view.tableview.TableView;

import java.util.List;

public class HotelsTableView implements TableView<Hotel> {

    @Override
    public String outputTable(List<Hotel> clients) {

        String sizes = "|%-10s|%-20s|%-10s|%-60s|%-10s|%n";
        StringBuilder sb = new StringBuilder(String.format(sizes, "ID", "Name", "Type", "Description", "Country ID"));
        if (clients != null) {
            for (Hotel client : clients) {
                Long id = client.getId();
                String name = client.getName();
                String type = client.getType();
                String description = client.getDescription();
                Long countryID = client.getCountryID();
                sb.append(String.format(sizes, id, name, type, description, countryID));
            }
        }
        return sb.toString();
    }
}
