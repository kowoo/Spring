package dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import common.Constant;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext context 
		  = new GenericXmlApplicationContext("dao/applicationContext.xml");
		
		BoardDao dao = context.getBean("boardDao",BoardDao.class);
		
		Map<String, Object> params = new HashMap<String,Object>();
		
//		0. 검색 하지 않음, 전체 선택
//		1. 제목검색        title
//		2. 이름검색        name
//		3. 제목+이름검색     title, name
//		4. 내용검색  content
		
		params.put("type", 1);
		params.put("TITLE", "제목없음");
		
		for(Map<String, Object> m: dao.searchBoard(params)) {
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