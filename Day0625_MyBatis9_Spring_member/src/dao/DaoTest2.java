package dao;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import common.Constant;

public class DaoTest2 {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao/applicationContext.xml");
		MemberDao dao = context.getBean("memberDao2",MemberDao.class);
		for(Map<String, Object> m : dao.selectAll()) {
			System.out.println("번호 : " + m.get(Constant.Member.NUM));
			System.out.println("성별 : " + m.get(Constant.Member.GENDER));
			System.out.println("이름 : " + m.get(Constant.Member.NAME));
			System.out.println("나이 : " + m.get(Constant.Member.AGE));
			System.out.println("---------------------");
		}
	}
}

