package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MessageDao;

@Service
public class MessageService {
	
	@Autowired
	private MessageDao msgDao;
	
	public boolean addMsg(Map<String, Object> msg) {
		if(msgDao.insertMsg(msg)>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean removeMsg(int num) {
		if(msgDao.deleteMsg(num)>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public Map<String, Object> getMsg(int num) {
		return msgDao.selectOne(num);
	}
	
	public List<Map<String, Object>> getAllMsg() {
		return msgDao.selectAll();
	}
}
