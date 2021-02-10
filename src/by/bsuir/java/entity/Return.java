package by.bsuir.java.entity;

import java.sql.Timestamp;

public class Return {
    private long id;
    private Timestamp saleTime;
    private int count;
    private String reason;
    private long clientID;
    private long employeeID;
    private long tourID;

    public Return() {
    }

    public Return(Timestamp saleTime, int count, String reason) {
        this.saleTime = saleTime;
        this.count = count;
        this.reason = reason;
    }

    public Return(Timestamp saleTime, int count, String reason, long clientID, long employeeID, long tourID) {
        this.saleTime = saleTime;
        this.count = count;
        this.reason = reason;
        this.clientID = clientID;
        this.employeeID = employeeID;
        this.tourID = tourID;
    }

    public Return(long id, Timestamp saleTime, int count, String reason, long clientID, long employeeID, long tourID) {
        this.id = id;
        this.saleTime = saleTime;
        this.count = count;
        this.reason = reason;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
        return "Return{" +
                "id=" + id +
                ", saleTime=" + saleTime +
                ", count=" + count +
                ", reason='" + reason + '\'' +
                ", clientID=" + clientID +
                ", employeeID=" + employeeID +
                ", tourID=" + tourID +
                '}';
    }
}
