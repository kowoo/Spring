package model;

public class Emp {
    int empno;
    String ename;
    public int getEmpno() {
              return empno;
    }
    public void setEmpno(int empno) {
              this.empno = empno;
    }
    public String getEname() {
              return ename;
    }
    public void setEname(String ename) {
              this.ename = ename;
    }
    public String toString() {
              return "empno = " + empno + ", ename = " + ename;
    }
}
