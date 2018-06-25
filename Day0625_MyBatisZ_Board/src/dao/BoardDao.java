package dao;

import java.util.List;
import java.util.Map;

public interface BoardDao {
	public int insertBoard(Map<String, Object> param);
	public int updateBoard(Map<String, Object> param);
	public int deleteBoard(Map<String, Object> param);
	public Map<String, Object> selectOne(Map<String, Object> param);
	public List<Map<String, Object>> selectAll();
}
