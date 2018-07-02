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
	public int memberJoin(Member m) {
		return dao.insert(m);
	}

	@Override
	public int memberUpdate(Member m) {
		return dao.update(m);
	}

	@Override
	public Member selectOne(String id) {
		return dao.selectOne(id);
	}

	@Override
	public List<Member> selectAll() {
		return dao.selectAll();
	}
}
