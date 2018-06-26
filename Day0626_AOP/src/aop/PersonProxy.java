package aop;

public class PersonProxy {
	//Girl이나 Boay의 기능을 대신 호출해주는 클래스
	Person person;
	public PersonProxy(Person person) {
		this.person = person;
	}
	public void callPerson() {
		System.out.println("전철을 탄다.");
		person.doSomething();
		System.out.println("종종 걸음으로 집에 도착한다.");
		System.out.println("다가올 내일을 기대하며 잠이 든다.");
	}
}
