package dao;

import java.util.List;

import model.Board;

public interface BoardDao {
	public int insertBoard(Board board);
	public int updateBoard(Board board);
	public int readCountUpByBoard(int num);
	public int deleteBoard(int num);
	public Board selectOne(int num);
	public List<Board> selectAll();
	public List<Board> selectBoardByPage(int firstPage, int endPage);
}
