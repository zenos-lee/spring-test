package dj.practice.toby.user.sqlservice;

/**
 * Created by Dongjoon on 2017. 7. 10..
 */
public interface SqlService {
    String getSql(String key) throws SqlRetrievalFailureException;
}

