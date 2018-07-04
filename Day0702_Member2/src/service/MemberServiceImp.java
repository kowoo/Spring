package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoardDao;
import dao.MemberDao;
import model.Board;
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
	@Override
	public boolean join(Member member) {
		System.out.println("여기 들어와?");
		System.out.println(member);
		Board board = new Board();
		board.setTitle(member.getName()+ " 가입인사입니다.");
		board.setName(member.getId());
		board.setPassword(member.getPassword());
		board.setEmail(member.getEmail());
		board.setContent("반갑습니다. 오늘 가입했습니다. "
		+ member.getName() + "입니다.");
		System.out.println(board);
		int rowCount = dao.insert(member);
		if(rowCount >0) {
			return true;
		}else {
			return false;
		}
	}
}
