package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BoardDao;
import dao.MemberDao;
import model.Board;
import model.Member;

@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BoardDao boardDao;
	
	
	@Override
	public List<Member> getAllMembers() {
		return memberDao.selectAll();
	}

	@Override
	public boolean login(String id, String pw) {
		// TODO Auto-generated method stub
		
		Member member = memberDao.selectOne(id);
		
		if(member != null) {
			//아이디 있음
			if(member.getPw().equals(pw)) {
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
	public Member getMemberById(String id) {
		return memberDao.selectOne(id);
	}

	@Transactional
	@Override
	public boolean join(Member member) {
		
		Board board = new Board();
		board.setTitle(member.getName()+ " 가입인ㅅㅏ");
		board.setName(member.getId());
		board.setPass(member.getPw());
		board.setEmail(member.getEmail());
		board.setContent("ㅎㅇ"	+ member.getName() + "입니다~");
		
		boardDao.insertBoard(board);
		
		int rowCount = memberDao.insertMember(member);
		if(rowCount >0) {
			return true;
		}else {
			return false;
		}
	}
}
