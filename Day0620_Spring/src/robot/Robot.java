package robot;

public class Robot {
	String name;
	Attackable attack;
	Moveable move;
	
	public void fight() {
		//이런 틀을 탬플릿이라고 하고. 탬플릿을 담고있는 메서드를 탬플릿 메서드라고 한다.
		System.out.println(name+" 전투 시작");
		attack();
		move();
		System.out.println(name+" 전투 종료");
	}
	public void attack() {
		attack.attack();
	}
	public void move() {
		move.move();
	}

}
