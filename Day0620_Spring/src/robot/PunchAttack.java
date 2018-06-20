package robot;

import org.springframework.stereotype.Component;

@Component("punch")
public class PunchAttack implements Attackable {
	public void attack() {
		System.out.println("주먹으로 공격!!"); //5만줄
	}
}
