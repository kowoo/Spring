package dao;

import java.util.List;

import model.Message;

public interface IMessageDao {
	public int insertMessage(Message msg);
	public int updateMessage(Message msg);
	public int deleteMessage(int id);
	public Message selectOne(int id);
	public List<Message> selectAll();
}
