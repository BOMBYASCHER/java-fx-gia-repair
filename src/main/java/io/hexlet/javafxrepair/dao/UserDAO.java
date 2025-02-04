package io.hexlet.javafxrepair.dao;

import io.hexlet.javafxrepair.model.User;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class UserDAO extends BaseDAO {
    public static int getUserIdByFio(String fio) {
        String sql = "SELECT id FROM users WHERE fio = ?";
        try (var ps = connection.prepareStatement(sql)) {
            ps.setString(1, fio);
            var rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(0);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    public static void createUser(User user) {
        String sql = "INSERT INTO users (fio, phone, login, password, type) VALUES (?, ?, ?, ?, ?)";
        try (var ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getFio());
            ps.setString(2, user.getPhone());
            ps.setString(3, user.getLogin());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getType());
            ps.executeUpdate();
            var generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Optional<User> getUserByFio(String fio) {
        String sql = "SELECT * FROM users WHERE fio = ?";
        try (var ps = connection.prepareStatement(sql)) {
            ps.setString(1, fio);
            var rs = ps.executeQuery();
            if (rs.next()) {
                Integer id = rs.getInt("id");
                String phone = rs.getString("phone");
                String login = rs.getString("login");
                String password = rs.getString("password");
                String type = rs.getString("type");
                User user = new User(type, password, login, phone, fio, id);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}
