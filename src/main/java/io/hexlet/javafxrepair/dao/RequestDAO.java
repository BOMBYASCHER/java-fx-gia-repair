package io.hexlet.javafxrepair.dao;

import io.hexlet.javafxrepair.model.Request;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestDAO extends BaseDAO {
    public static ObservableList<Request> getRequests() {
        String sql = "SELECT * FROM requests";
        List<Request> requests = new ArrayList<>();
        try (var ps = connection.prepareStatement(sql)) {
            var rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Date date = rs.getDate("start_date");
                String type = rs.getString("org_tech_type");
                String model = rs.getString("org_tech_model");
                String description = rs.getString("problem_description");
                String status = rs.getString("request_status");
                Date finish = rs.getDate("completion_date");
                String repairParts = rs.getString("repair_parts");
                int master = rs.getInt("masterID");
                int client = rs.getInt("clientID");
                Request request = new Request(
                        id,
                        date,
                        type,
                        model,
                        description,
                        status,
                        finish,
                        repairParts,
                        master,
                        client
                );
                requests.add(request);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return FXCollections.observableList(requests);
    }

    public static void addRequest(Request request) {
        String sql = "INSERT INTO requests VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (var ps = connection.prepareStatement(sql)) {
            ps.setInt(1, request.getId());
            ps.setDate(2, request.getStartDate());
            ps.setString(3, request.getType());
            ps.setString(4, request.getModel());
            ps.setString(5, request.getProblemDescription());
            ps.setString(6, request.getStatus());
            ps.setDate(7, request.getFinishDate());
            ps.setString(8, request.getRepairParts());
            ps.setObject(9, request.getMasterId());
            ps.setInt(10, request.getClientId());
            ps.execute();
//            System.out.println("EXECUTE REQUEST INT: "+ps.executeUpdate());
//            ps.executeUpdate();
//            var generatedKeys = ps.getGeneratedKeys();
//            if (generatedKeys.next()) {
//                request.setId(generatedKeys.getInt(1));
//            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void save(Request request) {
        String sql = "UPDATE requests SET ()"
    }
}
