package pl.coderslab.dao;

import pl.coderslab.db.DbUtil;
import pl.coderslab.models.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {

    private static final String CREATE_QUERY =
            "INSERT INTO vehicle(model, brand, production_year, plate_number, next_service_date, customer_id) VALUES (?, ?, ?, ? , ?, ?)";
    private static final String READ_QUERY =
            "SELECT * FROM vehicle WHERE id = ?";
    private static final String UPDATE_QUERY =
            "UPDATE vehicle SET model = ?, brand = ?, production_year = ?, plate_number = ?, next_servicel_date = ?, customer_id = ? where id = ?";
    private static final String DELETE_QUERY =
            "DELETE FROM vehicle WHERE id = ?";

    private static final String READ_ALL_FOR_CUSTOMER_ID_QUERY =
            "SELECT * FROM vehicle WHERE customer_id=?";
    private static final String READ_ALL_QUERY =
            "SELECT * FROM vehicle";

    public Vehicle create(Vehicle vehicle) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, vehicle.getModel());
            statement.setString(2, vehicle.getBrand());
            statement.setString(3, vehicle.getProductionYear());
            statement.setString(4, vehicle.getPlateNumber());
            statement.setString(5, vehicle.getNextServiceDate());
            statement.setInt(6, vehicle.getCustomerId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                vehicle.setId(resultSet.getInt(1));
            }
            return vehicle;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Vehicle read(int vehicleId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_QUERY);
            statement.setInt(1, vehicleId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(resultSet.getInt("id"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setProductionYear(resultSet.getString("production_year"));
                vehicle.setPlateNumber(resultSet.getString("plate_number"));
                vehicle.setNextServiceDate(resultSet.getString("next_service_date"));
                vehicle.setCustomerId(resultSet.getInt("customer_id"));
                return vehicle;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void update(Vehicle vehicle) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
            statement.setString(1, vehicle.getModel());
            statement.setString(2, vehicle.getBrand());
            statement.setString(3, vehicle.getProductionYear());
            statement.setString(4, vehicle.getPlateNumber());
            statement.setString(5, vehicle.getNextServiceDate());
            statement.setInt(6, vehicle.getCustomerId());
            statement.setInt(7, vehicle.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int vehicleId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_QUERY);
            statement.setInt(1, vehicleId);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Vehicle> readAllForCustomer(int customerId) {
        try (Connection conn = DbUtil.getConnection()) {
            List<Vehicle> vehicles = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(READ_ALL_FOR_CUSTOMER_ID_QUERY);
            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(resultSet.getInt("id"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setProductionYear(resultSet.getString("production_year"));
                vehicle.setPlateNumber(resultSet.getString("plate_number"));
                vehicle.setNextServiceDate(resultSet.getString("next_service_date"));
                vehicle.setCustomerId(resultSet.getInt("customer_id"));
                vehicles.add(vehicle);
            }
            return vehicles;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Vehicle> readAll() {
        try (Connection conn = DbUtil.getConnection()) {
            List<Vehicle> vehicles = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(READ_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(resultSet.getInt("id"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setProductionYear(resultSet.getString("production_year"));
                vehicle.setPlateNumber(resultSet.getString("plate_number"));
                vehicle.setNextServiceDate(resultSet.getString("next_service_date"));
                vehicle.setCustomerId(resultSet.getInt("customer_id"));
                vehicles.add(vehicle);
            }
            return vehicles;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}