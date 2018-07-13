package dao;

import java.util.List;
import java.util.Map;

public interface MemberDao {
	public Map<String, Object> selectOne(String id);
	public List<Map<String, Object>> selectAll();
}
