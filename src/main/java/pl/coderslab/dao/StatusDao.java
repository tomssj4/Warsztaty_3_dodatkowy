package pl.coderslab.dao;

import pl.coderslab.db.DbUtil;
import pl.coderslab.models.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StatusDao {
    private static final String READ_ALL_QUERY =
            "SELECT * FROM status ORDER BY id";

    public List<Status> readAll() {
        try (Connection conn = DbUtil.getConnection()) {
            List<Status> statuses = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(READ_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Status status = new Status();
                status.setId(resultSet.getInt("id"));
                status.setStatus(resultSet.getString("status"));
                statuses.add(status);
            }
            return statuses;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}