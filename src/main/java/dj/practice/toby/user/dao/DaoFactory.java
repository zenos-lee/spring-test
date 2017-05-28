package dj.practice.toby.user.dao;

/**
 * Created by Dongjoon on 2017. 5. 28..
 */
public class DaoFactory {
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

//    public AccountDao accountDao() {
//        return new AccountDao(connectionMaker());
//    }
//
//    public MessageDao messageDao() {
//        return new MessageDao(connectionMaker());
//    }


    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
