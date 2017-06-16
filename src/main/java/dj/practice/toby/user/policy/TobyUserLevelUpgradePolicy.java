package dj.practice.toby.user.policy;

import dj.practice.toby.user.dao.UserDao;
import dj.practice.toby.user.domain.Level;
import dj.practice.toby.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import static dj.practice.toby.user.service.UserService.MIN_LOGCOUNT_FOR_SILVER;
import static dj.practice.toby.user.service.UserService.MIN_RECCOMEND_FOR_GOLD;

/**
 * Created by Dongjoon on 2017. 6. 16..
 */
public class TobyUserLevelUpgradePolicy implements UserLevelUpgradePolicy{
    UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public void upgradeLevel(User user) {
        user.upgradeLevel();
        userDao.update(user);
    }

    public boolean canUpgradeLevel(User user) {
        Level currentLevel = user.getLevel();
        switch (currentLevel) {
            case BASIC: return (user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER);
            case SILVER: return (user.getRecommend() >= MIN_RECCOMEND_FOR_GOLD);
            case GOLD: return false;
            default: throw new IllegalArgumentException("Unknown Level: " + currentLevel);
        }
    }
}
