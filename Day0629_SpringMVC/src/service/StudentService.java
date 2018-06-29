package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StudentDao;
@Service
public class StudentService {
	@Autowired
	private StudentDao dao;
	
	public List<Map<String, Object>> selectStudentsByGrade(int grade) {
		return dao.selectStudentsByGrade(grade);
	}
	public List<Map<String, Object>> selectStudentList() {
		return dao.selectAll();
	}
	public boolean addStudent(String name, int grade) {
		Map<String, Object> param = new HashMap<String,Object>();
		param.put("name", name);
		param.put("grade", grade);
		
		System.out.println("num1 : " + param.get("num"));
		int result = dao.insertStudent(param);
		//insert 후에, 자동으로 생성된 num을 어떻게 가져오냐??
		System.out.println("num2 : " + param.get("num"));
		
		if(result > 0 ) {
			return true;
		}else {
			return false;
		}
	}
}
