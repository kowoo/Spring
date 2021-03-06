package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StudentDao;
import model.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	public List<Student> getAllStudents(){
		return studentDao.selectAll(); 
	}	
}
