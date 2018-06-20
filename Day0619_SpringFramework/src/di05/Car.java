package di05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	@Autowired(required=false)	//Autowired는 타입 우선 매칭이다.
								//의존성 주입 대상 타입의 bean이 존재하지 않을 경우 예외 발생!
								//단, required=false 속성을 지정하면 의존성 주입 객체가 존재하지 않아도 bean이 생성된다.(대신 널포인트가 뜨겠지? 익셉션 처리)
								//근데 required=false는 잘 사용되지 않는다고하네.
	@Qualifier("kTire")
	private Tire tire;
//  @Autowired가 tire.setTire(~)를 호출해주는 셈
//  즉, 의존성 주입!
	
	public void setTire(Tire tire) {
		this.tire = tire;
	}
//	public Car(Tire tire) {
//		this.tire = tire;
//	}
	
//	@Qualifier("kTire") 특정한 컴포넌트를 불러올 경우!
//	@Autowired
//	public void setTire(Tire tire) {
//		this.tire = tire;
//	}
	
	public void drive() {
		//실제로 수정된것은 타이어인데, Car역시도 수정해야 한다.
		//>> Car가 KoreaTire 객체의 제어권을 가지고 있기 때문이다.
		//>> 해결하기 위한 방법 : 제어역전 사용하는 객체를 직접 만들지 않고,상위객체에서 만들어서 전달
//		KoreaTire tire = new KoreaTire("굴러갑니다.");
		tire.roll();
	}
}
