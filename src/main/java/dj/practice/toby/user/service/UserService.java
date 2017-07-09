package dj.practice.toby.user.service;

import dj.practice.toby.user.domain.User;

import java.util.List;

/**
 * Created by Dongjoon on 2017. 6. 20..
 */
public interface UserService {
    void add(User user);
    User get(String id);
    List<User> getAll();
    void deleteAll();
    void update(User user);

    void upgradeLevels();
}
