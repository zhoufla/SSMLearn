package com.zhou.service;

import java.sql.SQLException;
import java.util.List;

import com.zhou.dao.IMessageDAO;
import com.zhou.dao.MessageDAOImpl;
import com.zhou.entity.Message;

/**
 * ListServlet的具体业务逻辑
 * 
 * @author zhou
 *
 */
public class ListService {
	public List<Message> queryMessageByParams(String command, String description) throws SQLException {
		IMessageDAO dao = new MessageDAOImpl();
		return dao.queryMessageByParams(command, description);
	}

	public List<Message> queryAllMessages() throws SQLException {
		IMessageDAO dao = new MessageDAOImpl();
		return dao.queryAllMessages();
	}

}
