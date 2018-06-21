package dao2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao2/applicationContext.xml");
		
		MessageDao dao = context.getBean("messageDao",MessageDao.class);
		
//		Map<String, Object> msg = new HashMap<String, Object>();
//		msg.put("id", 3);
//		msg.put("password", "3");
//		msg.put("name", "강아지");
//		msg.put("message", "멍멍!!");
//		dao.insertMessage(msg);
		
//		dao.deleteMessage(3);
		
		List<Map<String, Object>> list = dao.selectAll();
		for(Map<String, Object> m: list) {
			System.out.println(m);
		}
		
		
		
		
		
		
		
	}
}
