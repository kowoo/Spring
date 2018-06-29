package dao;

import java.util.List;
import java.util.Map;

public interface StudentDao {
	public int insertStudent(Map<String, Object> student);
	public int updateStudent(Map<String, Object> student);
	public int deleteStudent(int num);
	public Map<String, Object> selectOne(int num);
	public List<Map<String, Object>> selectStudentsByGrade(int grade);
	public List<Map<String, Object>> selectAll();
}
