package dao;

import java.util.List;
import java.util.Map;

import model.Member;

public interface MemberDao {
	public int insertStudent(Map<String, Object> student);
	public int updateStudent(Map<String, Object> student);
	public int deleteStudent(int num);
	public Member selectOne(int num);
	public List<Member> selectAll();
	
}
