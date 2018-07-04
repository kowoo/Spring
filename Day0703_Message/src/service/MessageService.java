package service;

import java.util.List;
import java.util.Map;

import model.Message;

public interface MessageService {
	public boolean addMessage(Message message);
	public int deleteMessage(int id, String pw);
	public List<Message> getAllMessages();
	public Map<String, Object> getMessageList(int pageNumber);
	public int calPageTotalCount(int totalCount);
	public int getStartPage(int pageNum);
	public int getEndPage(int pageNum);
}
