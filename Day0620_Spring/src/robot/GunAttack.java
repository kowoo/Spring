package robot;

import org.springframework.stereotype.Component;

@Component("gun")
public class GunAttack implements Attackable {
	public void attack() {
		System.out.println("총으로 공격!!"); //5만줄
	}
}
