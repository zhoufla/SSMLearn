package com.zhou.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zhou.entity.Message;
import com.zhou.util.DBAccess;

/**
 * 使用mybatis实现的DAO接口类
 * 
 * @author zhou
 *
 */
public class MessageDAOiBatisImpl implements IMessageDAO {
	private SqlSession session;

	@Override
	public List<Message> queryAllMessages() throws SQLException {
		List<Message> result = null;
		try {
			session = DBAccess.getSqlSession();
			result = session.selectList("Message.queryAllMessages");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				session = null;
			}
		}

		return result;
	}

	@Override
	public Message queryMessageById(int id) throws SQLException {
		return null;
	}

	@Override
	public List<Message> queryMessageByParams(String command, String description) throws SQLException {
		List<Message> result = null;
		try {
			session = DBAccess.getSqlSession();
			Message params = new Message();
			params.setCOMMAND(command);
			params.setDESCRIPTION(description);
			result = session.selectList("Message.queryAllMessagesByParams", params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				session = null;
			}
		}
		return result;
	}

	@Override
	public boolean insert(Message message) throws SQLException {
		return false;
	}

	@Override
	public boolean update(Message message) throws SQLException {
		return false;
	}

	@Override
	public boolean delete(Message message) throws SQLException {
		try {
			session = DBAccess.getSqlSession();
			session.delete("Message.deleteoneMessageById", message.getID());
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				session = null;
			}
		}
		return false;
	}

}
