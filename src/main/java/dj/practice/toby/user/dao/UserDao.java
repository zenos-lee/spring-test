package dj.practice.toby.user.dao;

import dj.practice.toby.user.domain.User;

import java.sql.*;

/**
 * Created by Dongjoon on 2017. 5. 26..
 */
public class UserDao {
    public void add(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c  = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/spring", "root", null
        );

        PreparedStatement ps = c.prepareStatement(
                "INSERT INTO users(id, name, password) VALUES (?, ?, ?)"
        );
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/spring", "root", null
        );

        PreparedStatement ps = c.prepareStatement(
                "SELECT * FROM users WHERE id = ?"
        );

        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }
}
