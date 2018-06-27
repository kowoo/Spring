package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.MemberDao;
import model.Member;
@Component("service")
public class MemberServiceImp implements MemberService {
	@Autowired
	private MemberDao memberDao;
//	public void getMemberList() {
//		for(Map<String, Object> map: memberDao.selectAll()) {
//			System.out.println("번호 : " + map.get("NUM"));
//			System.out.println("이름 : " + map.get("NAME"));
//			System.out.println("성별 : " + map.get("GENDER"));
//			System.out.println("나이 : " + map.get("AGE"));
//		}
//	}
	public List<Member> getMemberList() {
		return memberDao.selectAll();
	}
}
