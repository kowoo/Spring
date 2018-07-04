package dao;

import java.util.List;
import java.util.Map;

import model.Message;

public interface MessageDao {
	public int insertMessage(Message message);
	public int deleteMessage(int id);
	public Message selectOne(int id);
	public List<Message> selectAll();
	//보여줄 페이지를 처리
	public List<Message> selectList(Map<String, String> param);
	//총 메시지의 개수를 구함
	public int selectCount();
}
