package dj.practice.toby.user.sqlservice;

/**
 * Created by Dongjoon on 2017. 7. 18..
 */
public class DefaultSqlService extends BaseSqlService {
    public DefaultSqlService() {
        setSqlReader(new JaxbXmlSqlReader());
        setSqlRegistry(new HashMapSqlRegistry());
    }
}
