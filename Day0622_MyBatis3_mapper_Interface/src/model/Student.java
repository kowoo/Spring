package model;

public class Student {
	private int s_Num;
	private String sname;
	private int sgrade;
	
	public int gets_Num() {
		return s_Num;
	}
	public void sets_Num(int s_Num) {
		this.s_Num = s_Num;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSgrade() {
		return sgrade;
	}
	public void setSgrade(int sgrade) {
		this.sgrade = sgrade;
	}
	@Override
	public String toString() {
		return "Student [s_Num=" + s_Num + ", sname=" + sname + ", sgrade=" + sgrade + "]";
	}
}
