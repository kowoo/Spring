package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MemberMapper {
	@Insert("INSERT INTO member VALUES(#{num},#{gender},#{name},#{age})")
	public int insert(Map<String, Object> param);
	@Update("UPDATE member SET gender=#{gender}, name=#{name}, age=#{age} WHERE num = #{num}")
	public int update(Map<String, Object> param);
	@Delete("DELETE member WHERE num = #{num}")
	public int delete(int num);
	@Select("SELECT * FROM member WHERE num = #{num}")
	public Map<String, Object> selectOne(int num);
	@Select("SELECT * FROM member")
	public List<Map<String, Object>> selectAll();
}
