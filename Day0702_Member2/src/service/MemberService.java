package service;

import java.util.List;

import model.Member;

public interface MemberService {
	public int memberJoin(Member m);
	public int memberUpdate(Member m);
	public Member selectOne(String id);
	public List<Member> selectAll();
	public boolean join(Member member);
}
