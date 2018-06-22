package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class StudentDao {
	SqlSessionFactory sqlFac;
	
	public StudentDao() {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			sqlFac = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int insertStudent(Map<String, Object> params) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.insert("dao.StudentMapper.insert",params);
			//session.getMapper 인터페이스에 선언된 메서드를 실제로 사용할 수 있도록 만들어줌
		} finally {
			session.close();
		}
	}
	public int updateStudent(Map<String, Object> params) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.update("dao.StudentMapper.update", params);
			//session.getMapper 인터페이스에 선언된 메서드를 실제로 사용할 수 있도록 만들어줌
		} finally {
			session.close();
		}
	}	
	public int deleteStudent(int snum) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.delete("dao.StudentMapper.delete", snum);
			//session.getMapper 인터페이스에 선언된 메서드를 실제로 사용할 수 있도록 만들어줌
		} finally {
			session.close();
		}
	}
	public Map<String, Object> selectOne(int snum) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.selectOne("dao.StudentMapper.selectOne", snum);
			//session.getMapper 인터페이스에 선언된 메서드를 실제로 사용할 수 있도록 만들어줌
		} finally {
			session.close();
		}
	}	
	public List<Map<String, Object>> selectAll() {
		SqlSession session = sqlFac.openSession();
		try {
			return session.selectList("dao.StudentMapper.selectAll");
			//session.getMapper 인터페이스에 선언된 메서드를 실제로 사용할 수 있도록 만들어줌
		} finally {
			session.close();
		}
	}	
}
