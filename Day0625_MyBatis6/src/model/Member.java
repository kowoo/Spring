package model;

public class Member {
	private int num;
	private String gender;
	private String name;
	private int age;
	public Member() {}
	public Member(int num, String gender, String name, int age) {
		this.num = num;
		this.gender = gender;
		this.name = name;
		this.age = age;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "member [num=" + num + ", gender=" + gender + ", name=" + name + ", age=" + age + "]";
	}
}
