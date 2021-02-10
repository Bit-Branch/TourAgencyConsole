package by.bsuir.java.entity;

public class Hotel {
    private long id;
    private String name;
    private String type;
    private String description;
    private long countryID;

    public Hotel() {
    }

    public Hotel(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Hotel(String name, String type, String description, long countryID) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.countryID = countryID;
    }

    public Hotel(long id, String name, String type, String description, long countryID) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.countryID = countryID;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCountryID() {
        return countryID;
    }

    public void setCountryID(long countryID) {
        this.countryID = countryID;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", countryID=" + countryID +
                '}';
    }
}
