package di02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("d02/applicationContext.xml");
		
		Hello hello = (Hello)context.getBean("hello");
		hello.Hello();
	}
}
