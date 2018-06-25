package dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import common.Constant;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao/applicationContext.xml");
		BoardDao dao = context.getBean("boardDao", BoardDao.class);
//		Map<String, Object> param = new HashMap<String, Object>();
//		param.put("TITLE", "마이바티스");
//		param.put("NAME", "고웋");
//		param.put("PASSWORD", "qwer");
//		param.put("EMAIL", "abc@abc@abc@abc");
//		param.put("CONTENT", "마이바티스으으으으*2*2");
//		dao.insertBoard(param);
		
		for(Map<String, Object> m: dao.selectAll()) {
			System.out.println("번호 : " + m.get(Constant.Board.NUM));
			System.out.println("제목 : " + m.get(Constant.Board.TITLE));
			System.out.println("이름 : " + m.get(Constant.Board.NAME));
			System.out.println("비번 : " + m.get(Constant.Board.PASSWORD));
			System.out.println("메일 : " + m.get(Constant.Board.EMAIL));
			System.out.println("내용 : " + m.get(Constant.Board.CONTENT));
			System.out.println("조회 : " + m.get(Constant.Board.READCOUNT));
			System.out.println("날짜 : " + m.get(Constant.Board.WRITEDATE));
		}
	}
}

