package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StudentMapper {
	@Insert("INSERT INTO student VALUES (#{snum},#{sname},#{sgrade})")
	public int insertStudent(Map<String, Object> param);
	@Update("UPDATE student SET sname = #{sname} sgrade = #{sgrade} WHERE snum = #{snum}")
	public int updateStudent(Map<String, Object> param);
	@Delete("DELETE student WHERE snum = #{snum}")
	public int deleteStudent(int snum);
	@Select("SELECT * FROM student WHERE = #{snum}")
	public Map<String, Object> selectOne(int snum);
	@Select("SELECT * FROM student")
	public List<Map<String, Object>> selectAll();
}
