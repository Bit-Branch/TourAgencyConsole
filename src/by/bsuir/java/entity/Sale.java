package by.bsuir.java.entity;

import java.sql.Timestamp;

public class Sale {
    private long id;
    private Timestamp saleTime;
    private int count;
    private long clientID;
    private long employeeID;
    private long tourID;

    public Sale() {
    }

    public Sale(Timestamp saleTime, int count) {
        this.saleTime = saleTime;
        this.count = count;
    }

    public Sale(Timestamp saleTime, int count, long clientID, long employeeID, long tourID) {
        this.saleTime = saleTime;
        this.count = count;
        this.clientID = clientID;
        this.employeeID = employeeID;
        this.tourID = tourID;
    }

    public Sale(long id, Timestamp saleTime, int count, long clientID, long employeeID, long tourID) {
        this.id = id;
        this.saleTime = saleTime;
        this.count = count;
        this.clientID = clientID;
        this.employeeID = employeeID;
        this.tourID = tourID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Timestamp saleTime) {
        this.saleTime = saleTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public long getTourID() {
        return tourID;
    }

    public void setTourID(long tourID) {
        this.tourID = tourID;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", saleTime=" + saleTime +
                ", count=" + count +
                ", clientID=" + clientID +
                ", employeeID=" + employeeID +
                ", tourID=" + tourID +
                '}';
    }
}
