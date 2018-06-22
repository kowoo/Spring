package dao;

import java.util.List;

import model.Student;

public class DaoTest {
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		Student student = new Student();
//		student.setSnum(50);
//		student.setSname("고우혁");
//		student.setSgrade(4);
//		dao.insertStudent(student);
//		
		List<Student> list = dao.selectAll();
		for(Student s: list) {
			System.out.println(s);
		}
		
	}
}
