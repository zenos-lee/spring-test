package dj.practice.toby.learningtest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Dongjoon on 2017. 6. 25..
 */
public class UppercaseHandler implements InvocationHandler {
    Object target;

    public UppercaseHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = method.invoke(target, args);
        if (ret instanceof String &&
                method.getName().startsWith("say")
                ){
            return ((String)ret).toUpperCase();
        }
        else {
            return ret;
        }
    }
}
