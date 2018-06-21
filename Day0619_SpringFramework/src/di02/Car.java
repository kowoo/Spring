package di02;

public class Car {
	Tire tire = new KoreaTire("굴러갑니다.");
	
	//의존성 주입
//	public void setTire(Tire tire) {
//		this.tire = tire;
//	}
	public void drive() {
		//실제로 수정된 것은 타이어인데, Car도 수정해야 한다.
		//카 클래스가 코리아타이어 객체의 제어권을 가지고 있기 때문!
		//해결방법 = 제어역전 : 사용하는 객체를 직접만들지 않고, 상위객체에서 만들어서 전달.
		//상위객체(Driver)에서 만들어서 전달
//		KoreaTire tire = new KoreaTire("굴러갑니다");
		tire.roll();
	}
}
