package service;

import java.util.List;

import model.Member;

public interface MemberService {
	public int addMember(Member m);
	public Member selectOne(String id);
	public List<Member> selectAll();
	public boolean login(String id,String pw);
}
