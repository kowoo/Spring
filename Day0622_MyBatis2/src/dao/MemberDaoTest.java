package dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import common.Constant;

public class MemberDaoTest {
	public static void main(String[] args) {
		
		MemberDao dao = new MemberDao();
//		Map<String, Object> mem = dao.selectOne(1);
//		Iterator<String> it = mem.keySet().iterator();
//		while(it.hasNext()) {
//			//오라클은 키값을 대문자로 가져와버림.
//			//MySQL은 입력한거 그대로 가져옴.
//			System.out.println("key : " + it.next());
//		}
//		Map<String, Object> param = new HashMap<String, Object>();
//		param.put(Constant.Member.GENDER, "무");
//		param.put(Constant.Member.NAME, "신입");
//		param.put(Constant.Member.AGE, 20);
//		dao.insertMember(param);
		
		for(Map<String,Object> m: dao.selectAll()) {
			System.out.println("번호: " + m.get(Constant.Member.NUM));
			System.out.println("성별: " + m.get(Constant.Member.GENDER));
			System.out.println("이름: " + m.get(Constant.Member.NAME));
			System.out.println("나이: " + m.get(Constant.Member.AGE));
			System.out.println("------------------");
		}
	}
	
}
