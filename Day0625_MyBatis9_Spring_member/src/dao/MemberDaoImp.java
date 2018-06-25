package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//@Component
public class MemberDaoImp implements MemberDao {
	//@Autowired
	private SqlSessionFactory sqlFac;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlFac) {
		this.sqlFac = sqlFac;
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
