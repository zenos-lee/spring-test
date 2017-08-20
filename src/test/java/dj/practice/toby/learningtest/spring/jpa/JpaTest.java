package dj.practice.toby.learningtest.spring.jpa;

import dj.practice.toby.member.jpa.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/JpaTest-context.xml")
public class JpaTest {
    @Autowired
    PlatformTransactionManager transactionManager;
    @Autowired
    MemberTemplateDao templateDao;
    @Autowired
    MemberDao memberDao;
    @Autowired
    MemberRepositoryDao repositoryDao;

    @Autowired
    EntityManagerFactory emf;

    @Test(expected=PersistenceException.class)
    @Transactional
    public void jpaApiException() {
        memberDao.addDuplicatedId();
    }

    @Test(expected=DataAccessException.class)
    @Transactional
    public void jpaTemplateException() {
        templateDao.addDuplicatedId();
    }

    @Test(expected=DataAccessException.class)
    @Transactional
    public void jpaApiRepositoryException() {
        repositoryDao.addDuplicatedId();
    }


    @Test
    @Transactional
    public void sharedEntityManager() {
        memberDao.em.createQuery("delete from Member").executeUpdate();
        Member m = new Member(10, "Spring", 7.8);
        memberDao.em.persist(m);
        Long count = memberDao.em.createQuery("select count(m) from Member m", Long.class).getSingleResult();
        assertThat(count, is(1L));
    }

    @Test
    public void entityManagerFactory() {
        EntityManager em = memberDao.emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("delete from Member").executeUpdate();
        Member m = new Member(10, "Spring", 7.8);
        em.persist(m);
        Long count = em.createQuery("select count(m) from Member m", Long.class).getSingleResult();
        assertThat(count, is(1L));
        em.getTransaction().commit();
    }

    @Test
    @Transactional
    public void jpaTemplate(){
        templateDao.jpaTemplate.execute(new JpaCallback<Object>() {
            public Object doInJpa(EntityManager entityManager) throws PersistenceException {
                entityManager.createQuery("delete from Member").executeUpdate();
                return null;
            }
        });

        Member m = new Member(11, "Spring", 8.9);
        templateDao.jpaTemplate.persist(m);
        Member m2 = templateDao.jpaTemplate.find(Member.class, 11);
        assertThat(m.id, is(m2.id));
        assertThat(m.name, is(m2.name));
        assertThat(m.point, is(m2.point));

        List<Member> ms = templateDao.jpaTemplate.execute(new JpaCallback<List<Member>>() {
            public List<Member> doInJpa(EntityManager entityManager) throws PersistenceException {
                return entityManager.createQuery("select m from Member m").getResultList();
            }
        });
        System.out.println(ms.size());
    }

    public static class MemberDao {
        @PersistenceUnit
        EntityManagerFactory emf;
        @PersistenceContext(type=PersistenceContextType.EXTENDED)
        EntityManager em;

        public void addMember(Member member){
            em.persist(member);
        }
        public void addDuplicatedId() {
            em.persist(new Member(10, "Spring", 7.8));
            em.persist(new Member(10, "Spring", 7.8));
            em.flush();
        }

    }

    @Repository
    public static class MemberRepositoryDao {
        @PersistenceContext
        EntityManager em;

        public void addMember(Member member){
            em.persist(member);
        }

        public void addDuplicatedId() {
            em.persist(new Member(10, "Spring", 7.8));
            em.persist(new Member(10, "Spring", 7.8));
            em.flush();
        }

    }

    public static class MemberTemplateDao {
        JpaTemplate jpaTemplate;

        @Autowired
        public void init(EntityManagerFactory emf) {
            jpaTemplate = new JpaTemplate(emf);
        }

        public void addDuplicatedId() {
            jpaTemplate.persist(new Member(10, "Spring", 7.8));
            jpaTemplate.persist(new Member(10, "Spring", 7.8));
            jpaTemplate.flush();
        }
    }

}
