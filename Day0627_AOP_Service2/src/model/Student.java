package model;

public class Student {
	private String snum;
	private String sname;
	private String sgrade;
	public String getSnum() {
		return snum;
	}
	public void setSnum(String snum) {
		this.snum = snum;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSgrade() {
		return sgrade;
	}
	public void setSgrade(String sgrade) {
		this.sgrade = sgrade;
	}
	@Override
	public String toString() {
		return "Student [snum=" + snum + ", sname=" + sname + ", sgrade=" + sgrade + "]";
	}
}
