package com.zhou.service;

import java.sql.SQLException;
import java.util.List;

import com.zhou.dao.IMessageDAO;
import com.zhou.dao.MessageDAOiBatisImpl;
import com.zhou.entity.Message;

/**
 * ListServlet的具体业务逻辑
 * 
 * @author zhou
 *
 */
public class ListService implements Service{
	private IMessageDAO dao;

	public List<Message> queryMessageByParams(String command, String description) throws SQLException {
		dao = new MessageDAOiBatisImpl();
		return dao.queryMessageByParams(command, description);
	}

	public List<Message> queryAllMessages() throws SQLException {
		dao = new MessageDAOiBatisImpl();
		return dao.queryAllMessages();
	}

}
