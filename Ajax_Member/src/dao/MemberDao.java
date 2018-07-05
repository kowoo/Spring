package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	public int insertMember(Member member);
	public List<Member> selectAll();
}
