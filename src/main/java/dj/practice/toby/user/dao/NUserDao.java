package dj.practice.toby.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Dongjoon on 2017. 5. 28..
 */
public class NUserDao extends UserDao {

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c  = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/spring", "root", null
        );
        return c;
    }
}
