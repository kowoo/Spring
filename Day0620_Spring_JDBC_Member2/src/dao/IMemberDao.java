package dao;

import java.util.List;
import java.util.Map;

import model.Member;

public interface IMemberDao {
	public int insert(Member m);
	public int update(Member m);
	public int delete(int num);
	public Member selectOne(int num);
	public List<Map<String, Object>> selectAll();
}
