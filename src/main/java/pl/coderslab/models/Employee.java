package pl.coderslab.models;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private String address;
    private int number;
    private String note;
    private double manhourCost;

    public Employee() {
    }

    public Employee(String name, String surname, String address, int number, String note, double manhourCost) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.number = number;
        this.note = note;
        this.manhourCost = manhourCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getManhourCost() {
        return manhourCost;
    }

    public void setManhourCost(double manhourCost) {
        this.manhourCost = manhourCost;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", number=" + number +
                ", note='" + note + '\'' +
                ", manhourCost=" + manhourCost +
                '}';
    }
}
