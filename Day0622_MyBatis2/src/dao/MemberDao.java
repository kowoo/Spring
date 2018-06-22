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
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			sqlFac = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int insertMember(Map<String, Object> param) {
		SqlSession session = sqlFac.openSession();
		try {
			//인설트로 하든 업데이트로 하든 다 됨... 원래 그러잖어!
			return session.update("dao.memberMapper.insertMember", param);
		} finally {
			session.close();
		}
	}
	public int updateMember(Map<String, Object> param) {
		SqlSession session = sqlFac.openSession();
		try {
			//인설트로 하든 업데이트로 하든 다 됨... 원래 그러잖어!
			return session.update("dao.memberMapper.updateMember", param);
		} finally {
			session.close();
		}
	}
	public int deleteMember(int num) {
		SqlSession session = sqlFac.openSession();
		try {
			//인설트로 하든 업데이트로 하든 다 됨... 원래 그러잖어!
			return session.delete("dao.memberMapper.deleteMember", num);
		} finally {
			session.close();
		}
	}
	public Map<String, Object> selectOne(int num) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.selectOne("dao.memberMapper.selectOne", num);
		} finally {
			session.close();
		}
	}
	public List<Map<String, Object>> selectAll() {
		SqlSession session = sqlFac.openSession();
		try {
			return session.selectList("dao.memberMapper.selectAll");
		} finally {
			session.close();
		}
	}
}
