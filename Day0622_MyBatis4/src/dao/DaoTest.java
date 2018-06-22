package dao;

import java.util.HashMap;
import java.util.Map;

public class DaoTest {
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
//		Map<String, Object> member = new HashMap<String, Object>();
//		member.put("num", 6);
//		member.put("gender", "여");
//		member.put("name", "람쥐");
//		member.put("age", 50);
//		dao.insert(member);
		
		dao.delete(6);
		for(Map<String,Object> m: dao.selectAll()) {
			System.out.println("번호: " + m.get("NUM"));
			System.out.println("성별: " + m.get("GENDER"));
			System.out.println("이름: " + m.get("NAME"));
			System.out.println("나이: " + m.get("AGE"));
			System.out.println("------------------");
		}
	}
}
