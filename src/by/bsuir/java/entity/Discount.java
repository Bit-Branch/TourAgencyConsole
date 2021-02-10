package by.bsuir.java.entity;

public class Discount {
    private long id;
    private String name;
    private double size;

    public Discount() {
    }

    public Discount(String name, double size) {
        this.name = name;
        this.size = size;
    }

    public Discount(long id, String name, double size) {
        this.id = id;
        this.name = name;
        this.size = size;
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

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
