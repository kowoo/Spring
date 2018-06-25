package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//@Component("memberDao2")
public class MemberDaoImp2 implements MemberDao {
	//@Autowired
	SqlSession session;
	
	@Override
	public int insertMember(Map<String, Object> param) {
		return session.getMapper(MemberDao.class).insertMember(param);
	}
	@Override
	public int updateMember(Map<String, Object> param) {
		return session.getMapper(MemberDao.class).updateMember(param);
	}
	@Override
	public int deleteMember(Map<String, Object> param) {
		return session.getMapper(MemberDao.class).deleteMember(param);
	}

	@Override
	public Map<String, Object> selectOne(Map<String, Object> param) {
		return session.getMapper(MemberDao.class).selectOne(param);
	}
	@Override
	public List<Map<String, Object>> selectAll() {
		return session.getMapper(MemberDao.class).selectAll();
	}
}
