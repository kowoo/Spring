package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Message;

public class MessageDao implements IMessageDao {
	SqlSessionFactory sqlFac;

	public MessageDao() {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			sqlFac = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public int insertMessage(Message msg) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.insert("dao.messageMapper.insertMessage", msg);
		} finally {
			session.close();
		}
	}

	@Override
	public int updateMessage(Message msg) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.update("dao.messageMapper.updateMessage", msg);
		} finally {
			session.close();
		}
	}

	@Override
	public int deleteMessage(int id) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.delete("dao.messageMapper.deleteMessage", id);
		} finally {
			session.close();
		}
	}

	@Override
	public Message selectOne(int id) {
		SqlSession session = sqlFac.openSession();
		try {
			return session.selectOne("dao.messageMapper.selectOne", id);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Message> selectAll() {
		SqlSession session = sqlFac.openSession();
		try {
			return session.selectList("dao.messageMapper.selectAll");
		} finally {
			session.close();
		}
	}
	
}