package dj.practice.toby.user.dao;

import dj.practice.toby.user.domain.User;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Dongjoon on 2017. 5. 28..
 */
public class UserDaoTest {

    public static void main(String[] args){
        JUnitCore.main("dj.practice.toby.user.dao.UserDaoTest");
    }
    @Test
    public void addAnGet() throws SQLException, ClassNotFoundException{

        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("gyumee");
        user.setName("박성철");
        user.setPassword("springno1");

        dao.add(user);

        User user2 = dao.get(user.getId());

        assertThat(user2.getName(), is(user.getName()));
        assertThat(user2.getPassword(), is(user.getPassword()));

        dao.removeAll();
    }

}