package dj.practice.toby.user.dao;

import dj.practice.toby.user.domain.User;

import java.util.List;

/**
 * Created by Dongjoon on 2017. 6. 11..
 */
public interface UserDao {
    void add(User user);
    User get(String id);
    List<User> getAll();
    void deleteAll();
    int getCount();

    void update(User user1);
}
