package dao;

import model.Student;

public class daoTest {
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
//		Student s = new Student();
//		s.setSnum(10);
//		s.setSname("둘리");
//		s.setSgrade(1);
//		dao.insertStudent(s);
//		System.out.println("종료");
		for(Student s : dao.selectAll()) {
			System.out.println(s);
		}
	
	}
}
