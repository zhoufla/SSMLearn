package com.zhou.service;

import java.sql.SQLException;

import com.zhou.dao.IMessageDAO;
import com.zhou.dao.MessageDAOiBatisImpl;
import com.zhou.entity.Message;

/**
 * 维护相关的业务功能
 * 
 * @author zhou
 *
 */
public class MaintainService implements Service{
	private IMessageDAO dao;

	/**
	 * 删除单条
	 * 
	 * @param Id
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteOne(String Id) throws SQLException {
		Message message = new Message();
		if (Id == null)
			return false;
		message.setID(Integer.valueOf(Id));
		dao = new MessageDAOiBatisImpl();
		return dao.delete(message);
	}

}
