package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	public int insertMember(Member m);
	public Member selectOne(String id);
	public List<Member> selectAll();
}
