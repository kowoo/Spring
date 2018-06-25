package robot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class RobotTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("robot/applicationContext.xml");
//		Attackable attack = context.getBean("gun",Attackable.class);
//		Moveable move = context.getBean("fly",Moveable.class);
		Robot[] robot = new Robot[3];
		robot[0] = context.getBean("gundam",Robot.class);
		robot[1] = context.getBean("transformer",Robot.class);		
		robot[2] = context.getBean("taekwonV",Robot.class);		
		
		for(Robot r: robot) {
			System.out.println("-------");
			r.fight();
		}
		
		
	}
}
