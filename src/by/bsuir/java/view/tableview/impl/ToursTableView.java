package by.bsuir.java.view.tableview.impl;

import by.bsuir.java.entity.Sale;
import by.bsuir.java.entity.Tour;
import by.bsuir.java.view.tableview.TableView;

import java.sql.Timestamp;
import java.util.List;

public class ToursTableView implements TableView<Tour> {


    @Override
    public String outputTable(List<Tour> clients) {

        String sizes = "|%-10s|%-15s|%-7s|%-15s|%-10s|%-5s|%-5s|%-5s|%-5s|%-5s|%-5s|%n";
        StringBuilder sb = new StringBuilder(String.format(sizes, "ID", "Name","Price","Departure time", "Departure city","Adults count","Children count","Days count", "Nights count", "Hotel ID", "Discount ID"));
        if (clients != null) {
            for (Tour client : clients) {

                Long id = client.getId();
                String name = client.getName();
                double price = client.getPrice();
                Timestamp departureTime = client.getDepartureTime();
                String departureCity = client.getDepartureCity();
                int adultsCount = client.getAdultsCount();
                int childrenCount = client.getChildrenCount();
                int daysCount = client.getDaysCount();
                int nightsCount = client.getNightsCount();
                long hotelID = client.getHotelID();
                long discountID = client.getDiscountID();
                sb.append(String.format(sizes, id, name, price, departureTime,departureCity,adultsCount,childrenCount,daysCount,nightsCount,hotelID,discountID));
            }
        }
        return sb.toString();
    }
}