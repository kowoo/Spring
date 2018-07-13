package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;

@Service
public class MemberService {

	@Autowired
	private MemberDao memDao;
	
	public Map<String, Object> getMem(String id) {
		return memDao.selectOne(id);
	}
	
	public List<Map<String, Object>> getAllMems() {
		return memDao.selectAll();
	}
}
