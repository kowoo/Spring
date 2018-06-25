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
	SqlSessionFactory sqlSessionFactory;
	//SqlSession : DB접속, 자원관리, 예외처리 등의 역할
	//SqlSessionFactory : sqlSession을 얻어옴
	//SqlSession이 불안정해서 개발자가 직접 만들지 않고 SqlSessionFactory를 통해 제공한다고 함

	public StudentDao() {
		//설정 파일 읽어온 뒤 해당 정보를 이용해서 factory 객체 생성
		//SqlSessionFactoryBuilder : factory 객체를 만들어주는 클래스
		//build(스트림 : 설정 파일 내용을 담고 있는 스트림)

		InputStream is = null;
		try {									//마이바티스 설정 파일 이름 적어주자
			is = Resources.getResourceAsStream("configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int insertStudent(Student student) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.insert("dao.studentMapper.insertStudent",student);
		} finally {
			session.close();
		}
		// session.close(); 이렇게하면 return에서 이미 메서드가 끝나버리므로 세션을 닫을 수가 없다. 그래서 try에 리턴을 넣어줌
	}
	public int updateStudent(Student student) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.update("dao.studentMapper.updateStudent",student);
		} finally {
			session.close();
		}
	}
	public int deleteStudent(int snum) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.delete("dao.studentMapper.deleteStudent",snum);
		} finally {
			session.close();
		}
	}
	public Student selectOne(int snum) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectOne("dao.studentMapper.selectOne",snum);
		} finally {
			session.close();
		}
	}
	public List<Student> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectList("dao.studentMapper.selectAll");
		} finally {
			session.close();
		}
	}
}
