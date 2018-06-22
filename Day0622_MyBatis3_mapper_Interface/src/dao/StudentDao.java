package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Student;

public class StudentDao {
	SqlSessionFactory sqlFac;
	public StudentDao() {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			sqlFac = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int insertStudent(Student student) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.getMapper(StudentMapper.class).insertStudent(student);
			//session.getMapper 인터페이스에 선언된 메서드를 실제로 사용할 수 있도록 만들어줌
		} finally {
			session.close();
		}
	}
	public int deleteStudent(int snum) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.getMapper(StudentMapper.class).deleteStudent(snum);
			//session.getMapper 인터페이스에 선언된 메서드를 실제로 사용할 수 있도록 만들어줌
		} finally {
			session.close();
		}
	}
	public int updateStudent(Student student) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.getMapper(StudentMapper.class).updateStudent(student);
			//session.getMapper 인터페이스에 선언된 메서드를 실제로 사용할 수 있도록 만들어줌
		} finally {
			session.close();
		}
	}	
	public Student selectOne(int snum) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.getMapper(StudentMapper.class).selectOne(snum);
			//session.getMapper 인터페이스에 선언된 메서드를 실제로 사용할 수 있도록 만들어줌
		} finally {
			session.close();
		}
	}	
	public List<Student> selectAll() {
		SqlSession session = sqlFac.openSession();
		try {
			return session.getMapper(StudentMapper.class).selectAll();
			//session.getMapper 인터페이스에 선언된 메서드를 실제로 사용할 수 있도록 만들어줌
		} finally {
			session.close();
		}
	}	
}
