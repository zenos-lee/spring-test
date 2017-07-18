package dj.practice.toby.user.sqlservice;

/**
 * Created by Dongjoon on 2017. 7. 18..
 */
public class SqlNotFoundException extends RuntimeException {
    public SqlNotFoundException(String msg){
        super(msg);
    }
}
