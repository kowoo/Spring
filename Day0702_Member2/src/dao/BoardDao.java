package dao;

import java.util.List;

import model.Board;

public interface BoardDao {
	//insert,update,delete,selectOne,selectAll
	public int insert(Board board);
	public int update(Board board);
	public int delete(int num);
	public Board selectOne(int num);
	public int upReadCount(int num);
	public List<Board> selectAll();
}
