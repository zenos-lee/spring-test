package dj.practice.toby.user.dao;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

/**
 * Created by Dongjoon on 2017. 5. 28..
 */
//@Configuration
public class DaoFactory {
//    @Bean
    public UserDaoJdbc userDao() {
        UserDaoJdbc userDaoJdbc = new UserDaoJdbc();
        userDaoJdbc.setDataSource(dataSource());
        return userDaoJdbc;
    }

//    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring");
        dataSource.setUsername("root");
//        dataSource.setPassword("book");
        return dataSource;
    }

    //    @Bean
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
