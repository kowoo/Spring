package aop2;

import java.util.Random;

public class Girl implements Person{
	public String doSomething() throws Exception {
		System.out.println("쇼핑몰에서 쇼핑을 한다.");
		if(new Random().nextBoolean()) {
			throw new Exception("엄마 호출!!");
		}
		return "정상종료:Girl";
		//AOP를 이용하면 타겟의 return값을 받아서 그 이후에 실행될 메서드를 지정할 수 있다.
	}
	
}
