package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Student;

public interface StudentMapper {
	//우리가 dao에 만들고자 하는 메서드 선언
	@Insert("INSERT INTO student VALUES (#{snum},#{sname},#{sgrade})")
	public int insertStudent(Student student);
	
	@Update("UPDATE student SET sname = #{sname} sgrade = #{sgrade} WHERE snum = #{snum}")
	public int updateStudent(Student student);
	
	@Delete("DELETE student WHERE snum = #{snum}")
	public int deleteStudent(int snum);
	
	@Results({
		@Result(property ="s_Num", column = "snum"),
		@Result(property ="sname", column = "sname"),
		@Result(property ="sgrade", column ="sgrade")
	})
	@Select("select * " + 
			"		  from student " + 
			"		 where snum = #{snum} ")
	public Student selectOne(int snum);
	
	
	@Select("SELECT * FROM student")
	public List<Student> selectAll();
	
}
