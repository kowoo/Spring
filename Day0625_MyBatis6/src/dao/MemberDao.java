package dao;

import java.util.List;
import java.util.Map;

public interface MemberDao {
	public int insertMember(Map<String, Object> param);
	public int updateMember(Map<String, Object> param);
	public int deleteMember(Map<String, Object> param);
	public Map<String, Object> selectOne(Map<String, Object> param);
	public List<Map<String, Object>> selectAll();
}
