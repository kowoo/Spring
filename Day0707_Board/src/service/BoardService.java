package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoardDao;
import model.Board;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao dao;
	
	public boolean addBoard(Board board) {
		int result = dao.insertBoard(board);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	public boolean modifyBoard(Board board) {
		int result = dao.updateBoard(board);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	public void countUp(int num) {
		dao.readCountUpByBoard(num);
	}
	public boolean deleteBoard(int num) {
		int result = dao.deleteBoard(num);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	public Board getOneBoard(int num) {
		return dao.selectOne(num);
	}
	public List<Board> getAllBoardList() {
		return dao.selectAll();
	}
	public List<Board> getBoardListbyPage(int firstPage, int endPage) {
		return dao.selectBoardByPage(firstPage, endPage);
	}
}
