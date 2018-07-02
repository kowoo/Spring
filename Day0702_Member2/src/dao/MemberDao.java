package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	public int insert(Member m);
	public int update(Member m);
	public int delete(int num);
	public Member selectOne(String id);
	public List<Member> selectAll();
}
