package pl.coderslab.dao;

import pl.coderslab.db.DbUtil;
import pl.coderslab.models.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private static final String CREATE_QUERY =
            "INSERT INTO orders(start_service_date, planned_repair_date, start_repair_date, employee_id, problem_description, repair_description, status_id, repaired_vehicle_id, cost_repair_for_customer, cost_of_used_parts, man_hour_cost, number_of_man_hour) VALUES (?, ?, ?, ? , ?, ?,?,?,?,?,?,?)";
    private static final String READ_QUERY =
            "SELECT orders.*, vehicle.brand, vehicle.model, vehicle.plate_number, " +
                    "employee.name, employee.surname, customer.name as customerName, " +
                    "customer.surname as customerSurname, customer.id as customer_id, status.status FROM orders " +
                    "JOIN vehicle ON orders.repaired_vehicle_id = vehicle.id " +
                    "JOIN employee ON orders.employee_id = employee.id " +
                    "JOIN customer ON customer.id = vehicle.customer_id " +
                    "JOIN status ON status.id = orders.status_id " +
                    " where orders.id = ?";
    private static final String UPDATE_QUERY =
            "UPDATE orders SET start_service_date = ?, planned_repair_date = ? , start_repair_date = ?, employee_id = ?, problem_description = ?, repair_description = ?, status_id = ?, repaired_vehicle_id = ?, cost_repair_for_customer = ?, cost_of_used_parts = ?, man_hour_cost = ?, number_of_man_hour = ? where id = ?";
    private static final String DELETE_QUERY =
            "DELETE FROM orders WHERE id = ?";
    private static final String READ_ALL_FOR_STATUS_ID_QUERY =
            "SELECT orders.*, vehicle.brand, vehicle.model, vehicle.plate_number, " +
                    "employee.name, employee.surname, customer.name as customerName, " +
                    "customer.surname as customerSurname, customer.id as customer_id, status.status FROM orders " +
                    "JOIN vehicle ON orders.repaired_vehicle_id = vehicle.id " +
                    "JOIN employee ON orders.employee_id = employee.id " +
                    "JOIN customer ON customer.id = vehicle.customer_id " +
                    "JOIN status ON status.id = orders.status_id " +
                    " where status.id = ?";
    private static final String READ_ALL_FOR_EMPLOYEE_ID_QUERY =
            "SELECT orders.*, vehicle.brand, vehicle.model, vehicle.plate_number, " +
                    "employee.name, employee.surname, customer.name as customerName, " +
                    "customer.surname as customerSurname, customer.id as customer_id, status.status FROM orders " +
                    "JOIN vehicle ON orders.repaired_vehicle_id = vehicle.id " +
                    "JOIN employee ON orders.employee_id = employee.id " +
                    "JOIN customer ON customer.id = vehicle.customer_id " +
                    "JOIN status ON status.id = orders.status_id " +
                    " where employee_id = ?";
    private static final String READ_ALL_FOR_CUSTOMER_ID_QUERY =
            "SELECT orders.*, vehicle.brand, vehicle.model, vehicle.plate_number, " +
                    "employee.name, employee.surname, customer.name as customerName, " +
                    "customer.surname as customerSurname, customer.id as customer_id, status.status FROM orders " +
                    "JOIN vehicle ON orders.repaired_vehicle_id = vehicle.id " +
                    "JOIN employee ON orders.employee_id = employee.id " +
                    "JOIN customer ON customer.id = vehicle.customer_id " +
                    "JOIN status ON status.id = orders.status_id " +
                    " where customer.id=?";
    private static final String READ_ALL_FOR_VEHICLE_ID_QUERY =
            "SELECT orders.*, vehicle.brand, vehicle.model, vehicle.plate_number, " +
                    "employee.name, employee.surname, customer.name as customerName, " +
                    "customer.surname as customerSurname, customer.id as customer_id, status.status FROM orders " +
                    "JOIN vehicle ON orders.repaired_vehicle_id = vehicle.id " +
                    "JOIN employee ON orders.employee_id = employee.id " +
                    "JOIN customer ON customer.id = vehicle.customer_id " +
                    "JOIN status ON status.id = orders.status_id " +
                    "WHERE orders.repaired_vehicle_id = ?";
    private static final String READ_ALL_QUERY =
            "SELECT orders.*, vehicle.brand, vehicle.model, vehicle.plate_number, " +
                    "employee.name, employee.surname, customer.name as customerName, " +
                    "customer.surname as customerSurname, customer.id as customer_id, status.status FROM orders " +
                    "JOIN vehicle ON orders.repaired_vehicle_id = vehicle.id " +
                    "JOIN employee ON orders.employee_id = employee.id " +
                    "JOIN customer ON customer.id = vehicle.customer_id " +
                    "JOIN status ON status.id = orders.status_id ";


    public Order create(Order order) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement = setStatment(statement, order);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                order.setId(resultSet.getInt(1));
            }
            return order;
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return null;
    }

    public Order read(int orderId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_QUERY);
            statement.setInt(1, orderId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return setOrder(resultSet);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void update(Order order) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
            statement = setStatment(statement, order);
            statement.setInt(13, order.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void delete(int orderId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_QUERY);
            statement.setInt(1, orderId);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }


    public <T> List<Order> readAllFor(String caseName, T caseValue) {
        try (Connection conn = DbUtil.getConnection()) {
            List<Order> orders = new ArrayList<>();

            PreparedStatement statement;

            switch (caseName) {
            }

            switch (caseName) {
                case "employee":
                    statement = conn.prepareStatement(READ_ALL_FOR_EMPLOYEE_ID_QUERY);
                    break;
                case "customer":
                    statement = conn.prepareStatement(READ_ALL_FOR_CUSTOMER_ID_QUERY);
                    break;
                case "vehicle":
                    statement = conn.prepareStatement(READ_ALL_FOR_VEHICLE_ID_QUERY);
                    break;

                default: {
                    statement = conn.prepareStatement(READ_ALL_FOR_STATUS_ID_QUERY);
                }
            }
            if (caseValue instanceof Integer) {
                statement.setInt(1, (Integer) caseValue);
            } else {
                statement.setString(1, "%" + caseValue + "%");
            }


            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(setOrder(resultSet));
            }
            return orders;
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return null;
    }


    public List<Order> readAll() {
        try (Connection conn = DbUtil.getConnection()) {
            List<Order> orders = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(READ_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(setOrder(resultSet));
            }
            return orders;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    private static Order setOrder(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt("id"));
        order.setStartServiceDate(resultSet.getString("start_service_date"));
        order.setPlannedRepairDate(resultSet.getString("planned_repair_date"));
        order.setStartRepairDate(resultSet.getString("start_repair_date"));
        order.setEmployeeId(resultSet.getInt("employee_id"));
        order.setProblemDescription(resultSet.getString("problem_description"));
        order.setRepairDescription(resultSet.getString("repair_description"));
        order.setStatusId(resultSet.getInt("status_id"));
        order.setRepairedVehicleId(resultSet.getInt("repaired_vehicle_id"));
        order.setCostRepairForClient(resultSet.getDouble("cost_repair_for_customer"));
        order.setCostOfUsedParts(resultSet.getDouble("cost_of_used_parts"));
        order.setManhourCost(resultSet.getDouble("man_hour_cost"));
        order.setNumberOfManhour(resultSet.getInt("number_of_man_hour"));
        order.setBrand(resultSet.getString("brand"));
        order.setModel(resultSet.getString("model"));
        order.setPlateNumber(resultSet.getString("plate_number"));
        order.setEmployeeName(resultSet.getString("name"));
        order.setEmployeeSurname(resultSet.getString("surname"));
        order.setCustomerName(resultSet.getString("customerName"));
        order.setCustomerSurname(resultSet.getString("customerSurname"));
        order.setCustomerId(resultSet.getInt("customer_id"));
        order.setStatusStatus(resultSet.getString("status"));
        return order;
    }

    private static PreparedStatement setStatment(PreparedStatement statement, Order order) throws SQLException {
        statement.setString(1, order.getStartServiceDate());
        statement.setString(2, order.getPlannedRepairDate());
        statement.setString(3, order.getStartRepairDate());
        statement.setInt(4, order.getEmployeeId());
        statement.setString(5, order.getProblemDescription());
        statement.setString(6, order.getRepairDescription());
        statement.setInt(7, order.getStatusId());
        statement.setInt(8, order.getRepairedVehicleId());
        statement.setDouble(9, order.getCostRepairForClient());
        statement.setDouble(10, order.getCostOfUsedParts());
        statement.setDouble(11, order.getManhourCost());
        statement.setInt(12, order.getNumberOfManhour());
        return statement;
    }
}