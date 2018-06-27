package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.StudentDao;
import model.Student;

@Component("service")
public class StudentServiceImp implements StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public List<Student> getStudentList() {
		return studentDao.selectAll();
	}
	
}
