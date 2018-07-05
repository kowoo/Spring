package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	public List<Member> selectAll();
}
