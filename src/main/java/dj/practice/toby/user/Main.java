package dj.practice.toby.user;

import dj.practice.toby.user.dao.UserDao;
import dj.practice.toby.user.domain.User;

import java.sql.SQLException;

/**
 * Created by Dongjoon on 2017. 5. 26..
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao dao = new UserDao();

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + " 조회 성공");
    }
}
