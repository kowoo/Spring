package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Student;

public class StudentDaoImp implements StudentDao {
	SqlSessionFactory sqlFac;
	
	public StudentDaoImp() {
		InputStream is=null;
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			sqlFac = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insertStudent(Student s) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.getMapper(StudentDao.class).insertStudent(s);
		} finally {
			session.close();
		}
	}

	@Override
	public int updateStudent(Student s) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.getMapper(StudentDao.class).updateStudent(s);
		} finally {
			session.close();
		}
	}

	@Override
	public int deleteStudent(int snum) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.getMapper(StudentDao.class).deleteStudent(snum);
		} finally {
			session.close();
		}
	}

	@Override
	public Student selectOne(int snum) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.getMapper(StudentDao.class).selectOne(snum);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Student> selectAll() {
		SqlSession session = sqlFac.openSession();
		try {
			return session.getMapper(StudentDao.class).selectAll();
		} finally {
			session.close();
		}
	}
	
}
