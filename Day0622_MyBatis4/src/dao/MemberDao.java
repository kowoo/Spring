package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDao {
	SqlSessionFactory sqlFac;
	
	public MemberDao() {
		InputStream is=null;
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			sqlFac = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int insert(Map<String, Object> param) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.insert("dao.MemberMapper.insert",param);
		}finally {
			session.close();
		}
	}
	public int update(Map<String, Object> param) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.update("dao.MemberMapper.update",param);
		}finally {
			session.close();
		}
	}
	public int delete(int num) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.delete("dao.MemberMapper.delete",num);
		}finally {
			session.close();
		}
	}
	public Map<String, Object> selectOne(int num) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.selectOne("dao.MemberMapper.selectOne",num);
		}finally {
			session.close();
		}
	}
	public List<Map<String, Object>> selectAll() {
		SqlSession session = sqlFac.openSession();
		try {
			return session.selectList("dao.MemberMapper.selectAll");
		}finally {
			session.close();
		}
	}
}
