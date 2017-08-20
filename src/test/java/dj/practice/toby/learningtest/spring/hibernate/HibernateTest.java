package dj.practice.toby.learningtest.spring.hibernate;

import dj.practice.toby.member.jpa.Member;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/hibernateTest-context.xml")
public class HibernateTest {
    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    MemberTemplateDao templateDao;

    @Autowired
    MemberDao dao;

    @Test
    @Transactional
    public void hibernateTemplate() {
        templateDao.hibernateTemplate.bulkUpdate("delete from Member");
        Member m = new Member(1, "Hibernate", 1.2);
        templateDao.hibernateTemplate.save(m);
        long count = templateDao.hibernateTemplate.execute(new HibernateCallback<Long>() {
            public Long doInHibernate(Session s) throws HibernateException, SQLException {
                return (Long) s.createQuery("select count(m) from Member m").uniqueResult();
            }});
        assertThat(count, is(1L));
    }

    @Test
    @Transactional
    public void hiberateApi(){
        Session s = dao.sessionFactory.getCurrentSession();
        s.createQuery("delete from Member").executeUpdate();
        Member m = new Member(1, "Hibernate", 1.2);
        s.save(m);
        long count = (Long) s.createQuery("select count(m) from Member m").uniqueResult();
        assertThat(count, is(1L));
    }


    public static class MemberTemplateDao {
        private HibernateTemplate hibernateTemplate;

        @Autowired
        public void setSessionFactory(SessionFactory sessionFactory) {
            hibernateTemplate = new HibernateTemplate(sessionFactory);
        }

    }

    public static class MemberDao {
        @Autowired
        SessionFactory sessionFactory;
    }
}
