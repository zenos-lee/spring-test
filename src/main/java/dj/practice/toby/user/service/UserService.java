package dj.practice.toby.user.service;

import dj.practice.toby.user.domain.User;

/**
 * Created by Dongjoon on 2017. 6. 20..
 */
public interface UserService {
    void add(User user);
    void upgradeLevels();
}
