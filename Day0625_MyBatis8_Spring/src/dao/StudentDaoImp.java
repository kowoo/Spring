package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Student;

public class StudentDaoImp implements StudentDao {
	private SqlSessionFactory sqlFac;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlFac) {
		this.sqlFac = sqlFac;
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
