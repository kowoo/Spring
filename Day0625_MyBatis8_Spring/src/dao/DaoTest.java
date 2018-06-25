package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.Student;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao/applicationContext.xml");
		StudentDao dao = context.getBean("studentDao",StudentDao.class);
		
//		Student tmp = new Student();
//		tmp.setsnum(3);
//		tmp.setSname("강감찬");
//		tmp.setSgrade(4);
//		dao.insertStudent(tmp);
//		Student tmp2 = dao.selectOne(2);
//		tmp2.setSgrade(5);
//		dao.updateStudent(tmp2);
		
		for(Student s: dao.selectAll()) {
			System.out.println(s);
		}
	}
}
