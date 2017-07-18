package dj.practice.toby.user.sqlservice;

/**
 * Created by Dongjoon on 2017. 7. 18..
 */
public interface SqlRegistry {
    void registerSql(String key, String sql);

    String findSql(String key) throws SqlNotFoundException;
}
