package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.Member;

public class MemberDao implements IMemberDao {
	
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Member m) {
		String sql = "insert into member values(?,?,?,?)";
		return jdbcTemplate.update(sql, m.getNum(), m.getGender(), m.getName(), m.getAge());
	}

	@Override
	public int update(Member m) {
		String sql = "update member set gender=? name=? age=? where num=?";
		return jdbcTemplate.update(sql, m.getGender(), m.getName(), m.getAge(), m.getAge());
	}

	@Override
	public int delete(int num) {
		String sql = "delete member where num=?";
		return jdbcTemplate.update(sql, num);
	}

	@Override
	public Member selectOne(int num) {
		String sql = "select * from member where num=?";
		return jdbcTemplate.queryForObject(sql, memberMapper);
	}

	@Override
	public List<Map<String, Object>> selectAll() {
		String sql = "select * from member";
		return jdbcTemplate.query(sql, memberMapper2);
	}
	
	RowMapper<Member> memberMapper = new RowMapper<Member>() {
		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			Member member = new Member();
			member.setNum(rs.getInt("num"));
			member.setGender(rs.getString("gender"));
			member.setName(rs.getString("name"));
			member.setAge(rs.getInt("age"));
			return member;
		}
	};
	
	RowMapper<Map<String, Object>> memberMapper2 = new RowMapper<Map<String, Object>>() {
		@Override
		public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("num", rs.getInt("num"));
			result.put("gender", rs.getString("gender"));
			result.put("name", rs.getString("name"));
			result.put("age", rs.getInt("age"));
			return result;
		}
		
	};
	
}

