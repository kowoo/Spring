package di05;

import org.springframework.stereotype.Component;

@Component("kTire")   
public class KoreaTire implements Tire{
	String str;
//	public KoreaTire(String str) {
//		this.str = str;
//	}
	public void roll() {
		System.out.println("국산타이어 굴러갑니다.");
//		System.out.println("국산타이어 :" + str);
	}
}
