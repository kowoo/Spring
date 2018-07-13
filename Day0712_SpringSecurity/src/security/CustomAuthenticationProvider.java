package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserDetailsService userDetailService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		//사용자가 입력한 비밀번호와 service가 가져다 준 사용자 정보의 비밀번호가 같으면 권한 제공
		UsernamePasswordAuthenticationToken authToken;
		
		String memberid = authentication.getName();
		String password = (String)authentication.getCredentials();
		
		UserDetails member = userDetailService.loadUserByUsername(memberid);
		if(member == null) {
			throw new UsernameNotFoundException(memberid);
		}
		if(!password.equals(member.getPassword())) {
			throw new BadCredentialsException("사용자가 없거나 비밀번호 불일치입니다.");
		} else {
			//비밀번호 일치
			authToken 
			= new UsernamePasswordAuthenticationToken(memberid,password,member.getAuthorities());
			System.out.println("authToken : " + authToken);
			return authToken;
		}
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(arg0);
	}
	//Spring security 에서 사용자에 대한 권한을 제공하는 클래스 
	
}
