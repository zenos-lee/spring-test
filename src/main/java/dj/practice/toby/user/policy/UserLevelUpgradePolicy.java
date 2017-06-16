package dj.practice.toby.user.policy;

import dj.practice.toby.user.domain.User;

/**
 * Created by Dongjoon on 2017. 6. 16..
 */
public interface UserLevelUpgradePolicy {
    boolean canUpgradeLevel(User user);
    void upgradeLevel(User user);
}
