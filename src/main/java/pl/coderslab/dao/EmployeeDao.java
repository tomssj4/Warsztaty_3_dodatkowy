package pl.coderslab.dao;

import pl.coderslab.db.DbUtil;
import pl.coderslab.models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    private static final String CREATE_QUERY =
            "INSERT INTO employee(name, surname, address, number, note, man_hour_cost) VALUES (?, ?, ?, ? , ? ,?)";
    private static final String READ_QUERY =
            "SELECT * FROM employee WHERE id = ?";
    private static final String UPDATE_QUERY =
            "UPDATE employee SET name = ?, surname = ?, address = ?, number = ?, note = ?, man_hour_cost = ? where id = ?";
    private static final String DELETE_QUERY =
            "DELETE FROM employee WHERE id = ?";

    private static final String READ_ALL_QUERY =
            "SELECT * FROM employee ORDER BY id";

    public Employee create(Employee employee) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSurname());
            statement.setString(3, employee.getAddress());
            statement.setInt(4, employee.getNumber());
            statement.setString(5, employee.getNote());
            statement.setDouble(6, employee.getManhourCost());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                employee.setId(resultSet.getInt(1));
            }
            return employee;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Employee read(int employeeId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_QUERY);
            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSurname(resultSet.getString("surname"));
                employee.setAddress(resultSet.getString("address"));
                employee.setNumber(resultSet.getInt("number"));
                employee.setNote(resultSet.getString("note"));
                employee.setManhourCost(resultSet.getDouble("man_hour_cost"));
                return employee;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void update(Employee employee) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSurname());
            statement.setString(3, employee.getAddress());
            statement.setInt(4, employee.getNumber());
            statement.setString(5, employee.getNote());
            statement.setDouble(6, employee.getManhourCost());
            statement.setInt(7, employee.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int employeeId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_QUERY);
            statement.setInt(1, employeeId);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Employee> readAll() {
        try (Connection conn = DbUtil.getConnection()) {
            List<Employee> employees = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(READ_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSurname(resultSet.getString("surname"));
                employee.setAddress(resultSet.getString("address"));
                employee.setNumber(resultSet.getInt("number"));
                employee.setNote(resultSet.getString("note"));
                employee.setManhourCost(resultSet.getDouble("man_hour_cost"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}