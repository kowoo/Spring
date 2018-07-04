package dao;

import java.util.List;
import java.util.Map;

public interface ReplyDao {
	public int insertReply(Map<String, Object> reply);
	public int updateReply(Map<String, Object> reply);
	public int deleteReply(int replyNum);
	public Map<String, Object> selectOne(int replyNum);
	public List<Map<String, Object>> selectByBoardNum(int boardNum);
}
