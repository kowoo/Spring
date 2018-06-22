package dao;

import java.util.List;

import model.Message;

public class MessageDaoTest {
	public static void main(String[] args) {
		IMessageDao dao = new MessageDao();
		Message msg = new Message();
		msg.setId(4);
		msg.setPassword("12345");
		msg.setName("고우혁");
		msg.setMessage("금요일이에요!!!!!");
		
		dao.insertMessage(msg);
		System.out.println(dao.selectOne(4));
		List<Message> list = dao.selectAll();
		
		for(Message m: list) {
			System.out.println(m);
		}
		
	}
	
}
