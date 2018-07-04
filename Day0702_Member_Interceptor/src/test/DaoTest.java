package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.MemberDao;
import model.Member;

@RunWith(SpringJUnit4ClassRunner.class) //테스트를 위한 junit 클래스
@ContextConfiguration("file:WebContent/WEB-INF/spring/root-context.xml") // dao를 테스트 하기 위한 스프링컨테이너 주소.
public class DaoTest {
	//기존의 test는 main을 사용. 하지만 junit을 사용하면 main 만들 필요 없음
	
	//스프링 컨테이너가 생성되어야 만들어지는 녀석이므로 @RunWith(SpringJUnit4ClassRunner.class)를 이용
	//@ContextConfiguration이 로딩이 되면 MemberDao가 준비된 상태
	@Autowired
	private MemberDao memberDao;
	
	@Test //테스트 메서드임을 선언.
	public void memberDaoTest() {
		Member member = new Member();
		member.setId("id10");
		member.setName("테스트");
		member.setPw("10");
		member.setEmail("id10@gmail.com");
		
		memberDao.insertMember(member);
	}
	
}
