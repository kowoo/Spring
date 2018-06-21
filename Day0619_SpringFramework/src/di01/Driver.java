package di01;

public class Driver {
	public static void main(String[] args) {
		Car car = new Car();
		//Tire tire = new KoreaTire("굴러갑니다.");
		ChinaTire tire = new ChinaTire();
		
		car.setTire(tire);
		car.drive();
	}
	
}
