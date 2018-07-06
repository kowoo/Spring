package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.NaverDao;

@Service
public class NaverService {
	
	@Autowired
	private NaverDao dao;
	
	public void add(String ir1) {
		dao.insert(ir1);
	}
}
