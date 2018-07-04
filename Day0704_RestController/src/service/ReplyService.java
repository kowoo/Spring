package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReplyDao;

@Service
public class ReplyService {
	
	@Autowired
	private ReplyDao dao;
	
	public boolean addReply(Map<String, Object> reply) {
		if(dao.insertReply(reply)==1) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<Map<String, Object>> getBoardReply(int boardNum) {
		return dao.selectByBoardNum(boardNum);
	}
}
