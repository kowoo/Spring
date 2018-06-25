package dao;

import model.Student;

public class DaoTest {
	public static void main(String[] args) {
		StudentDao dao = new StudentDaoImp();
		
//		Student tmp = new Student();
//		tmp.setsnum(3);
//		tmp.setSname("강감찬");
//		tmp.setSgrade(4);
//		dao.insertStudent(tmp);
		Student tmp2 = dao.selectOne(2);
		tmp2.setSgrade(5);
		dao.updateStudent(tmp2);
		
		for(Student s: dao.selectAll()) {
			System.out.println(s);
		}
	}
}
