package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import dao.MessageDao;
import model.Message;

@Service
public class MessageServiceImp implements MessageService {
	//한페이지에 표시될 메시지의 개수
	private static final int NUM_OF_MESSAGE_PER_PAGE = 10;
	//한번에 표시될 네비게이션의 개수
	private static final int NUM_OF_NAVI_PAGE = 10;
	
	@Autowired
	private MessageDao messageDao; 
	
	@Override
	public boolean addMessage(Message message) {
		// TODO Auto-generated method stub
		int result = messageDao.insertMessage(message);
		boolean insertResult = false;
		if(result==1) {
			insertResult = true;
		}
		return insertResult;
	}

	@Override
	public int deleteMessage(int id,String pw) {
		// TODO Auto-generated method stub
		if(messageDao.selectOne(id).getPassword().equals(pw)) {
			System.out.println("pw일치, 메시지 삭제");
			return messageDao.deleteMessage(id);
		} else {
			return 0;
		}
	}

	@Override
	public List<Message> getAllMessages() {
		// TODO Auto-generated method stub
		return messageDao.selectAll();
	}
	
	public Map<String, Object> getMessageList(int pageNumber) {
		Map<String, Object> viewData
		 = new HashMap<String,Object>();
		int firstRow = 0;
		int endRow =0;
		int totalCount = 0;  //총 메시지의 개수, 총 페이지수를 구하기 위해 필요
		totalCount  = messageDao.selectCount(); //총메시지 개수
		firstRow = (pageNumber-1)*NUM_OF_MESSAGE_PER_PAGE +1;
		endRow = pageNumber*NUM_OF_MESSAGE_PER_PAGE;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("firstRow", String.valueOf(firstRow));
		map.put("endRow", String.valueOf(endRow));
		
		List<Message> messageList = messageDao.selectList(map);
		
		viewData.put("currentPage",pageNumber);
		viewData.put("messageList", messageList);
		viewData.put("pageTotalCount",calPageTotalCount(totalCount));
		viewData.put("startPage", getStartPage(pageNumber));
		viewData.put("endPage", getEndPage(pageNumber));
		return viewData;
	}
	
	public int calPageTotalCount(int totalCount) {
		int pageTotalCount = 0;
		if(totalCount != 0) {
			pageTotalCount = (int)Math.ceil(
					((double)totalCount / NUM_OF_MESSAGE_PER_PAGE));
		}
		return pageTotalCount;
	}
	
	public int getStartPage(int pageNum) {
		int startPage = 
				((pageNum-1)/NUM_OF_NAVI_PAGE)*NUM_OF_NAVI_PAGE + 1;
		return startPage;
	}
	
	public int getEndPage(int pageNum) {
		int endPage 
		= (((pageNum-1)/NUM_OF_NAVI_PAGE)+1)
		* NUM_OF_NAVI_PAGE;
		return endPage;
	}
}
