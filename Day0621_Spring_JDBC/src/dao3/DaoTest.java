package dao3;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.Board;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao3/applicationContext.xml");
		IBoardDao dao = context.getBean("boardDao",IBoardDao.class);
		
//		Board board1 = new Board();
//		board1.setTitle("스프링 입니다!");
//		board1.setName("홍길동");
//		board1.setPass("123");
//		board1.setEmail("abc@naver.com");
//		board1.setContent("ㅠㅠㅠㅠㅠㅠ점심먹고싶어요 ㅠㅠㅠㅠㅠㅠ");
//		dao.insertBoard(board1);
//		System.out.println("종료");
		
//		Board board2 = new Board();
//		board2.setNum(1);
//		board2.setTitle("스프링 입니다!");
//		board2.setName("홍길동");
//		board2.setPass("1234");
//		board2.setEmail("abc@naver.com");
//		board2.setContent("ㅠㅠㅠㅠㅠㅠ점심먹고싶어요 ㅠㅠㅠㅠㅠㅠ");
//		dao.updateBoard(board2);
//		System.out.println("종료");
		
		System.out.println(dao.selectOne(1));
		List<Board> list = dao.selectAll();
		for(Board b: list) {
			System.out.println(b);
		}
		
	}
}
