package aop;

public class AopTest {
	public static void main(String[] args) {
//		Boy boy = new Boy();
//		Girl girl = new Girl();
//		boy.doSomeThing();
//		girl.doSomeThing();
		
		PersonProxy proxy = new PersonProxy(new Boy());
		proxy.callPerson();
	}

}
