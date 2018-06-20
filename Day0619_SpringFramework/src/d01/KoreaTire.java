package d01;

public class KoreaTire implements Tire {
	String str;
	public KoreaTire(String str) {
		this.str = str;
	}
	public void roll() {
		System.out.println("국산 타이어 : ");
	}
}
