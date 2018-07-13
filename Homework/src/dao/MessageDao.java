package dao;

import java.util.List;
import java.util.Map;

public interface MessageDao {
	public int insertMsg(Map<String, Object> msg);
	public int deleteMsg(int num);
	public Map<String, Object> selectOne(int num);
	public List<Map<String, Object>> selectAll();
}
