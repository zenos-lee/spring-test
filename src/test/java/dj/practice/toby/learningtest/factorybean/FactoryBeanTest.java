package dj.practice.toby.learningtest.factorybean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

/**
 * Created by Dongjoon on 2017. 6. 25..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/FactoryBeanTest-context.xml")
public class FactoryBeanTest {
    @Autowired
    ApplicationContext context;

    @Test
    public void getMessageFromFactoryBean() {
        Object message = context.getBean("message");
        assertThat(message, instanceOf(Message.class));
        assertThat(((Message)message).getText(), is("Factory Bean"));
    }

    @Test
    public void getFactoryBean() throws Exception{
        Object factory = context.getBean("&message");
        assertThat(factory, instanceOf(MessageFactoryBean.class));
    }
}