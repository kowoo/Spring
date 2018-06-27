package aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MemberAspect {

	private static final Logger LOGGER = Logger.getLogger(MemberAspect.class);
	
	//service 패키지의 ServiceImp로 끝나는 클래스의 모든 메서드에 반응
	@Pointcut("execution(* service.*ServiceImp.*(..))")
	public void servicept() {
	}
	@Before("servicept()")
	public void startService(JoinPoint jp) {
		//System.out.println(jp.getTarget());
		//System.out.println("서비스 시작!");
		LOGGER.debug("DEBUG : ====서비스 시작합니다====");
		LOGGER.info("INFO : ====서비스 시작합니다====");
	}
	@After("servicept()")
	public void endService() {
		//System.out.println("종료합니다.");
		LOGGER.debug("DEBUG : ====서비스 시작합니다====");
		LOGGER.info("INFO : ====서비스 시작합니다====");
	}
	
}
