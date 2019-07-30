package pl.coderslab.models;

public class Order {
    private int id;
    private String startServiceDate;
    private String plannedRepairDate;
    private String startRepairDate;
    private int employeeId;
    private String problemDescription;
    private String repairDescription;
    private int statusId;
    private int repairedVehicleId;
    private double costRepairForClient;
    private double costOfUsedParts;
    private double manhourCost;
    private int numberOfManhour;

    private String brand;
    private String model;
    private String plateNumber;

    private String employeeName;
    private String employeeSurname;

    private String customerName;
    private String customerSurname;

    private String statusStatus;

    private int customerId;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurName) {
        this.employeeSurname = employeeSurName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurName) {
        this.customerSurname = customerSurName;
    }

    public String getStatusStatus() {
        return statusStatus;
    }

    public void setStatusStatus(String statusStatus) {
        this.statusStatus = statusStatus;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Order() {
    }

    public Order(String startServiceDate, String plannedRepairDate, String startRepairDate, int employeeId, String problemDescription, String repairDescription, int statusId, int repairedVehicleId, double costRepairForClient, double costOfUsedParts, double manhourCost, int numberOfManhour) {
        this.startServiceDate = startServiceDate;
        this.plannedRepairDate = plannedRepairDate;
        this.startRepairDate = startRepairDate;
        this.employeeId = employeeId;
        this.problemDescription = problemDescription;
        this.repairDescription = repairDescription;
        this.statusId = statusId;
        this.repairedVehicleId = repairedVehicleId;
        this.costRepairForClient = costRepairForClient;
        this.costOfUsedParts = costOfUsedParts;
        this.manhourCost = manhourCost;
        this.numberOfManhour = numberOfManhour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartServiceDate() {
        return startServiceDate;
    }

    public void setStartServiceDate(String startServiceDate) {
        this.startServiceDate = startServiceDate;
    }

    public String getPlannedRepairDate() {
        return plannedRepairDate;
    }

    public void setPlannedRepairDate(String plannedRepairDate) {
        this.plannedRepairDate = plannedRepairDate;
    }

    public String getStartRepairDate() {
        return startRepairDate;
    }

    public void setStartRepairDate(String startRepairDate) {
        this.startRepairDate = startRepairDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getRepairedVehicleId() {
        return repairedVehicleId;
    }

    public void setRepairedVehicleId(int repairedVehicleId) {
        this.repairedVehicleId = repairedVehicleId;
    }

    public double getCostRepairForClient() {
        return costRepairForClient;
    }

    public void setCostRepairForClient(double costRepairForClient) {
        this.costRepairForClient = costRepairForClient;
    }

    public double getCostOfUsedParts() {
        return costOfUsedParts;
    }

    public void setCostOfUsedParts(double costOfUsedParts) {
        this.costOfUsedParts = costOfUsedParts;
    }

    public double getManhourCost() {
        return manhourCost;
    }

    public void setManhourCost(double manhourCost) {
        this.manhourCost = manhourCost;
    }

    public int getNumberOfManhour() {
        return numberOfManhour;
    }

    public void setNumberOfManhour(int numberOfManhour) {
        this.numberOfManhour = numberOfManhour;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", startServiceDate='" + startServiceDate + '\'' +
                ", plannedRepairDate='" + plannedRepairDate + '\'' +
                ", startRepairDate='" + startRepairDate + '\'' +
                ", employeeId=" + employeeId +
                ", problemDescription='" + problemDescription + '\'' +
                ", repairDescription='" + repairDescription + '\'' +
                ", statusId=" + statusId +
                ", repairedVehicleId=" + repairedVehicleId +
                ", costRepairForClient=" + costRepairForClient +
                ", costOfUsedParts=" + costOfUsedParts +
                ", manhourCost=" + manhourCost +
                ", numberOfManhour=" + numberOfManhour +
                '}';
    }
}
