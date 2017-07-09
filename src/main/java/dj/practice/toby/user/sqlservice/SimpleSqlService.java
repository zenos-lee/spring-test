package dj.practice.toby.user.sqlservice;

import java.util.Map;

/**
 * Created by Dongjoon on 2017. 7. 10..
 */
public class SimpleSqlService implements SqlService {
    private Map<String, String> sqlMap;
    public void setSqlMap(Map<String, String> sqlMap) {
        this.sqlMap = sqlMap;
    }
    @Override
    public String getSql(String key) throws SqlRetrievalFailureException {
        String sql = sqlMap.get(key);
        if (sql == null) {
            throw new SqlRetrievalFailureException(key + "에 대한 SQLdㅡㄹ 찾을 수 없습니다");
        }
        else {
            return sql;
        }
    }
}
