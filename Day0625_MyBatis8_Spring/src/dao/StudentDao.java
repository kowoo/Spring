package dao;

import java.util.List;

import model.Student;

public interface StudentDao {
	public int insertStudent(Student s);
	public int updateStudent(Student s);
	public int deleteStudent(int snum);
	public Student selectOne(int snum);
	public List<Student> selectAll();
}
