package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao dao;
	
	public List<Map<String, Object>> selectAll() {
		return dao.selectAll(); 
	}
}
