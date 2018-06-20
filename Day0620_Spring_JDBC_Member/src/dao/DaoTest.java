package dao;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao/applicationContext.xml");
		
		IMemberDao dao = (MemberDao) context.getBean("memberDao");
		
		List<Map<String, Object>> list = dao.selectAll();
		for(Map<String, Object> member: list) {
			System.out.println(member);
		}
		
	}
}
