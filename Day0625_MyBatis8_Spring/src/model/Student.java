package model;

public class Student {
	private int snum;
	private String sname;
	private int sgrade;
	
	public int getsnum() {
		return snum;
	}
	public void setsnum(int snum) {
		this.snum = snum;
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
		return "Student [snum=" + snum + ", sname=" + sname + ", sgrade=" + sgrade + "]";
	}
}
