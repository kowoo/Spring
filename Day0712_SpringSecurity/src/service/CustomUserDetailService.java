package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import dao.MemberDao;
import model.Member;
import model.Role;
import model.SMember;

@Component
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public UserDetails loadUserByUsername(String memberid) throws UsernameNotFoundException {
		//사용자의 권한 가져오기, 권한 부여  
		//UserDetails : 사용자의 권한을 가지고 있는 클래스
		//CustomUserDetailService : UserDetails의 인터페이스
		
		
		//현재 로그인 하려는 사용자 정보를 db에서 얻어온 뒤, 정보를 이용해서 UserDetails를 만든다.
		SMember smember = new SMember();

		//실제 db에 저장된 사용자 정보
		Member member = memberDao.selectOne(memberid);
		
		//db에 아이디가 존재하면 ROLE_USER 권한 부여
		if(member != null) {
			smember.setPassword(member.getPw());
			smember.setUsername(member.getId());
			smember.addAuthority(new Role("ROLE_USER"));
			
		}
		return smember;
	}
	
}
