package by.bsuir.java.entity;

import java.sql.Timestamp;

public class Tour {
    private long id;
    private String name;
    private double price;
    private Timestamp departureTime;
    private String departureCity;
    private int adultsCount;
    private int childrenCount;
    private int daysCount;
    private int nightsCount;
    private long hotelID;
    private long discountID;

    public Tour() {
    }

    public Tour(String name, double price, Timestamp departureTime, String departureCity, int daysCount, int nightsCount) {
        this.name = name;
        this.price = price;
        this.departureTime = departureTime;
        this.departureCity = departureCity;
        this.daysCount = daysCount;
        this.nightsCount = nightsCount;
    }

    public Tour(String name, double price, Timestamp departureTime, String departureCity, int adultsCount, int childrenCount, int daysCount, int nightsCount, long hotelID, long discountID) {
        this.name = name;
        this.price = price;
        this.departureTime = departureTime;
        this.departureCity = departureCity;
        this.adultsCount = adultsCount;
        this.childrenCount = childrenCount;
        this.daysCount = daysCount;
        this.nightsCount = nightsCount;
        this.hotelID = hotelID;
        this.discountID = discountID;
    }

    public Tour(long id, String name, double price, Timestamp departureTime, String departureCity, int adultsCount, int childrenCount, int daysCount, int nightsCount, long hotelID, long discountID) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.departureTime = departureTime;
        this.departureCity = departureCity;
        this.adultsCount = adultsCount;
        this.childrenCount = childrenCount;
        this.daysCount = daysCount;
        this.nightsCount = nightsCount;
        this.hotelID = hotelID;
        this.discountID = discountID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public int getAdultsCount() {
        return adultsCount;
    }

    public void setAdultsCount(int adultsCount) {
        this.adultsCount = adultsCount;
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
    }

    public int getDaysCount() {
        return daysCount;
    }

    public void setDaysCount(int daysCount) {
        this.daysCount = daysCount;
    }

    public int getNightsCount() {
        return nightsCount;
    }

    public void setNightsCount(int nightsCount) {
        this.nightsCount = nightsCount;
    }

    public long getHotelID() {
        return hotelID;
    }

    public void setHotelID(long hotelID) {
        this.hotelID = hotelID;
    }

    public long getDiscountID() {
        return discountID;
    }

    public void setDiscountID(long discountID) {
        this.discountID = discountID;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", departureTime=" + departureTime +
                ", departureCity='" + departureCity + '\'' +
                ", adultsCount=" + adultsCount +
                ", childrenCount=" + childrenCount +
                ", daysCount=" + daysCount +
                ", nightsCount=" + nightsCount +
                ", hotelID=" + hotelID +
                ", discountID=" + discountID +
                '}';
    }
}
