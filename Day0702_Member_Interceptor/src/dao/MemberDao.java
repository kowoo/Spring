package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	public int insert(Member m);
	public int update(Member m);
	public int delete(int num);
	public Member selectOne(int num);
	public List<Member> selectAll();
}
