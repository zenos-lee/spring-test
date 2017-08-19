package dj.practice.toby.learningtest.spring.ibatis;


import com.ibatis.sqlmap.client.SqlMapClient;
import dj.practice.toby.member.dao.MemberDao;
import dj.practice.toby.member.dto.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/daoApplicationContext.xml")
public class IbatisTest {
    @Autowired
    MemberDao dao;

    @Test
    public void ibatis() {
        dao.deleteAll();
        dao.insert(new Member(5, "iBatis", 1.2));
        dao.insert(new Member(6, "sqlMap", 3.3));

        Member m = dao.select(5);
        assertThat(m.getId(), is(5));
        assertThat(m.getName(), is("iBatis"));
        assertThat(m.getPoint(), is(1.2));

        List<Member> ms = dao.selectAll();
        assertThat(ms.size(), is(2));

    }

}