package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Member;

public class MemberDaoImp implements MemberDao {
	private SqlSessionFactory sqlFac;
	public MemberDaoImp() {
		InputStream is=null;
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			sqlFac = new SqlSessionFactoryBuilder().build(is); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public int insertMember(Map<String, Object> param) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.getMapper(MemberDao.class).insertMember(param);
		} finally {
			session.close();
		}
		
	}
	@Override
	public int updateMember(Map<String, Object> param) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.getMapper(MemberDao.class).updateMember(param);
		} finally {
			session.close();
		}
	}
	@Override
	public int deleteMember(Map<String, Object> param) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.getMapper(MemberDao.class).deleteMember(param);
		} finally {
			session.close();
		}
	}

	@Override
	public Map<String, Object> selectOne(Map<String, Object> param) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.getMapper(MemberDao.class).selectOne(param);
		} finally {
			session.close();
		}
	}
	@Override
	public List<Map<String, Object>> selectAll() {
		SqlSession session = sqlFac.openSession();
		try {
			return session.getMapper(MemberDao.class).selectAll();
		} finally {
			session.close();
		}
	}
}
