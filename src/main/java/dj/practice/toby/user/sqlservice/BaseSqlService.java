package dj.practice.toby.user.sqlservice;

import javax.annotation.PostConstruct;

/**
 * Created by Dongjoon on 2017. 7. 18..
 */
public class BaseSqlService implements SqlService {

    private SqlReader sqlReader;
    private SqlRegistry sqlRegistry;

    public void setSqlReader(SqlReader sqlReader) {
        this.sqlReader = sqlReader;
    }

    public void setSqlRegistry(SqlRegistry sqlRegistry) {
        this.sqlRegistry = sqlRegistry;
    }

    @PostConstruct
    public void loadSql() {
        this.sqlReader.read(sqlRegistry);
    }

    @Override
    public String getSql(String key) throws SqlRetrievalFailureException {
        try {
            return this.sqlRegistry.findSql(key);
        } catch (SqlNotFoundException e){
            throw new SqlRetrievalFailureException(e.getMessage());
        }
    }
}
