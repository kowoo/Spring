package dao3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import model.Board;

@Component
public class BoardDao implements IBoardDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public int insertBoard(Board board) {
		String sql = "insert into board values (board_seq.nextval,:title,:name,:password,:email,:content,0,sysdate)";
		//sql에 들어갈 변수와 값을 key-value 매핑으로 정의
		//>>map을 이용해서 변수 설정
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("title", board.getTitle());
		params.put("email", board.getEmail());
		params.put("password", board.getPass());
		params.put("name", board.getName());
		params.put("content", board.getContent());
		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int updateBoard(Board board) {
		String sql = "update board set title = :title, name = :name, password = :pass, email = :email, content = :content where num = :num";
		
		//쉽게 파라미터 map를 만들어보자
		//자바 빈의 멤버를 map으로 변환해주는 클래스
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(board);
		return jdbcTemplate.update(sql, params);
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("num", board.getNum());
//		params.put("title", board.getTitle());
//		params.put("email", board.getEmail());
//		params.put("password", board.getPass());
//		params.put("name", board.getName());
//		params.put("content", board.getContent());
//		return jdbcTemplate.update(sql, params);
		
		//엄청나게 짧아짐!
	}

	@Override
	public int deleteBoard(int num) {
		String sql = "delete board where :num";
		
		//파라미터가 하나인 경우 사용할 수 있는 맵
		return jdbcTemplate.update(sql, Collections.singletonMap("num", num));
		
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("num", num);
//		return jdbcTemplate.update(sql, params);
	}

	@Override
	public Board selectOne(int num) {
		String sql = "select * from board where num = :num";
		MapSqlParameterSource param = new MapSqlParameterSource("num", num);
		return (Board)jdbcTemplate.queryForObject(sql, param, boardMapper);
		
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("num", num);
//		return (Board) jdbcTemplate.queryForObject(sql, params, boardMapper);
	}

	@Override
	public List<Board> selectAll() {
		String sql = "select * from board";
		//jdbcTemplate.getJdbcOperations().queryForList(sql);
		return jdbcTemplate.query(sql, boardMapper);
	}
	
	RowMapper<Board> boardMapper = new RowMapper<Board> () {
		@Override
		public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
			Board result = new Board();
			result.setNum(rs.getInt("num"));
			result.setTitle(rs.getString("title"));
			result.setName(rs.getString("name"));
			result.setPass(rs.getString("password"));
			result.setEmail(rs.getString("email"));
			result.setContent(rs.getString("content"));
			result.setReadCount(rs.getInt("readCount"));
			result.setWriteDate(rs.getDate("writeDate"));
			return result;
		}
	};
	
}
