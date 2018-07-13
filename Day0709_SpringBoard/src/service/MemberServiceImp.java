package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import model.Member;

@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	private MemberDao dao;
	
	@Override
	public int addMember(Member m) {
		return dao.insertMember(m);
	}

	@Override
	public Member selectOne(String id) {
		return dao.selectOne(id);
	}
	@Override
	public boolean login(String id, String pw) {
		// TODO Auto-generated method stub
		Member member = dao.selectOne(id);
		if(member != null) {
			//아이디 있음
			if(member.getPassword().equals(pw)) {
				return true;
			}else {
				return false;
			}
		}else {
			//아이디 없음 : 로그인 실패 
			return false;
		}
	}
	@Override
	public List<Member> selectAll() {
		return dao.selectAll();
	}
}
