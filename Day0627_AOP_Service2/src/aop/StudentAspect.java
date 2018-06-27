package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StudentAspect {
	
	@Pointcut("execution(* service.*ServiceImp.*(..))")
	public void studentServicept() {
	}
	
	@Before("studentServicept()")
	public void startStudentService(JoinPoint jp) {
		System.out.println("서비스 시작!");
	}
	@After("studentServicept()")
	public void endStudentService(JoinPoint jp) {
		System.out.println("서비스 종료!");
	}
}
