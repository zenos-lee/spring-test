package dj.practice.toby.user.service;

import dj.practice.toby.user.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dongjoon on 2017. 6. 20..
 */

@Transactional
public interface UserService {
    void add(User user);
    @Transactional(readOnly = true)
    User get(String id);
    @Transactional(readOnly = true)
    List<User> getAll();
    void deleteAll();
    void update(User user);

    void upgradeLevels();
}
