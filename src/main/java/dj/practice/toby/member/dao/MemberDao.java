package dj.practice.toby.member.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import dj.practice.toby.member.dto.Member;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

public class MemberDao {

    private SqlMapClientTemplate sqlMapClientTemplate;

    public void setSqlMapClient(SqlMapClient sqlMapClient){
        sqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
    }

    public void insert(Member m) { sqlMapClientTemplate.insert("insertMember", m); }
    public void deleteAll() { sqlMapClientTemplate.delete("deleteMemberAll"); }
    public Member select(int id) { return (Member)sqlMapClientTemplate.queryForObject("findMemberById", id); }
    public List<Member> selectAll() { return sqlMapClientTemplate.queryForList("findMembers"); }

}
