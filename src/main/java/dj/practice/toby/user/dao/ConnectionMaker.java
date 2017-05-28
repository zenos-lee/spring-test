package dj.practice.toby.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Dongjoon on 2017. 5. 28..
 */
public interface ConnectionMaker {

    public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
