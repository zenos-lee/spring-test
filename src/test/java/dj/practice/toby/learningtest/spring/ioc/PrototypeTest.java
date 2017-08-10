package dj.practice.toby.learningtest.spring.ioc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PrototypeTest {
    @Test
    public void singletonScope() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class, SingletonClientBean.class);
        Set<SingletonBean> beans = new HashSet<SingletonBean>();
        beans.add(ac.getBean(SingletonBean.class));
        beans.add(ac.getBean(SingletonBean.class));
        assertThat(beans.size(), is(1));

        beans.add(ac.getBean(SingletonClientBean.class).bean1);
        beans.add(ac.getBean(SingletonClientBean.class).bean2);
        assertThat(beans.size(), is(1));
    }

    static class SingletonBean {}

    static class SingletonClientBean {
        @Autowired
        SingletonBean bean1;
        @Autowired
        SingletonBean bean2;
    }

    @Test
    public void prototypeScope() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class, PrototypeClientBean.class);
        Set<PrototypeBean> beans = new HashSet<PrototypeBean>();
        beans.add(ac.getBean(PrototypeBean.class));
        assertThat(beans.size(), is(1));
        beans.add(ac.getBean(PrototypeBean.class));
        assertThat(beans.size(), is(2));
        beans.add(ac.getBean(PrototypeClientBean.class).bean1);
        assertThat(beans.size(), is(3));
        beans.add(ac.getBean(PrototypeClientBean.class).bean2);
        assertThat(beans.size(), is(4));
    }

    @Scope("prototype")
    static class PrototypeBean {}

    static class PrototypeClientBean {
        @Autowired
        PrototypeBean bean1;
        @Autowired
        PrototypeBean bean2;
    }

}
