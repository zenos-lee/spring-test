package dj.practice.toby.user.service;

import dj.practice.toby.user.dao.UserDao;
import dj.practice.toby.user.domain.Level;
import dj.practice.toby.user.domain.User;
import dj.practice.toby.user.policy.UserLevelUpgradePolicy;

import java.util.List;

/**
 * Created by Dongjoon on 2017. 6. 15..
 */
public class UserService {
    UserDao userDao;
    UserLevelUpgradePolicy userLevelUpgradePolicy;
    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECCOMEND_FOR_GOLD = 30;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserLevelUpgradePolicy(UserLevelUpgradePolicy userLevelUpgradePolicy) {
        this.userLevelUpgradePolicy = userLevelUpgradePolicy;
    }

    public void upgradeLevels() {
        List<User> users = userDao.getAll();
        for(User user: users) {
            if( userLevelUpgradePolicy.canUpgradeLevel(user)) {
                userLevelUpgradePolicy.upgradeLevel(user);
            }
        }
    }



    public void add(User user) {
        if(user.getLevel() == null){
            user.setLevel(Level.BASIC);
        }
        userDao.add(user);
    }
}
