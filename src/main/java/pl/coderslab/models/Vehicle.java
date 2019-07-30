package pl.coderslab.models;

public class Vehicle {
    private int id;
    private String model;
    private String brand;
    private String productionYear;
    private String plateNumber;
    private String nextServiceDate;
    private int customerId;

    public Vehicle() {
    }

    public Vehicle(String model, String brand, String productionYear, String plateNumber, String nextServiceDate, int customerId) {
        this.model = model;
        this.brand = brand;
        this.productionYear = productionYear;
        this.plateNumber = plateNumber;
        this.nextServiceDate = nextServiceDate;
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getNextServiceDate() {
        return nextServiceDate;
    }

    public void setNextServiceDate(String nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", productionYear='" + productionYear + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", nextServiceDate='" + nextServiceDate + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
