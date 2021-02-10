package by.bsuir.java.entity;

public class Client {
    private long id;
    private String surname;
    private String name;
    private String patronymic;
    private String passport;
    private String email;
    private String phone;
    private long accountID;

    public Client() {
    }

    public Client(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public Client(String surname, String name, String patronymic, String passport, String email, String phone, long accountID) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.passport = passport;
        this.email = email;
        this.phone = phone;
        this.accountID = accountID;
    }

    public Client(long id, String surname, String name, String patronymic, String passport, String email, String phone, long accountID) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.passport = passport;
        this.email = email;
        this.phone = phone;
        this.accountID = accountID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", passport='" + passport + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", accountID=" + accountID +
                '}';
    }
}
