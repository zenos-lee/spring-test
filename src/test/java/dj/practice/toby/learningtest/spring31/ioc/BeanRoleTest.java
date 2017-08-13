package dj.practice.toby.learningtest.spring31.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanRoleTest {
    @Test
    public void testBean() {
        ApplicationContext context = new GenericXmlApplicationContext(BeanRoleTest.class,
                "/beanrole.xml");
        SimpleConfig sc = context.getBean(SimpleConfig.class);
        sc.hello.sayHello();
        BeanDefinitionUtils.printBeanDefinitions((GenericApplicationContext)context);
    }


}
