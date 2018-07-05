package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import model.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao dao;
	
	public boolean addMember(Member member) {
		int result = dao.insertMember(member);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<Member> getMemberList() {
		return dao.selectAll();
	}
}
