package com.zhou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhou.entity.Message;
import com.zhou.util.DbcpUtil;

public class MessageDAOImpl implements IMessageDAO {
	private PreparedStatement psmt;
	private Connection connection;
	private ResultSet rs;

	@Override
	public List<Message> queryAllMessages() throws SQLException {
		List<Message> result = new ArrayList<>();
		connection = DbcpUtil.getConnection();
		String sql = "select id,command,description,content from message";
		psmt = connection.prepareStatement(sql);
		rs = psmt.executeQuery();
		while (rs.next()) {
			Message message = new Message();
			message.setID(rs.getInt("ID"));
			message.setCOMMAND(rs.getString("COMMAND"));
			message.setCONTENT("CONTENT");
			message.setDESCRIPTION(rs.getString("DESCRIPTION"));
			result.add(message);
		}
		close();
		return result;
	}

	@Override
	public Message queryMessageById(int id) throws SQLException {
		connection = DbcpUtil.getConnection();
		Message message = null;
		String sql = "select id,command,description,content from message where ID=?";
		psmt = connection.prepareStatement(sql);
		psmt.setInt(1, id);
		rs = psmt.executeQuery();
		while (rs.next()) {
			message = new Message();
			message.setID(rs.getInt("ID"));
			message.setCOMMAND(rs.getString("COMMAND"));
			message.setCONTENT("CONTENT");
			message.setDESCRIPTION(rs.getString("DESCRIPTION"));
		}
		close();
		return message;
	}

	@Override
	public boolean insert(Message message) throws SQLException {
		connection = DbcpUtil.getConnection();
		String sql = "INSERT INTO MESSAGE(ID,COMMAND,DESCRIPTION,CONTENT) VALUES(?,?,?,?)";
		psmt = connection.prepareStatement(sql);
		psmt.setInt(1, message.getID());
		psmt.setString(2, message.getCOMMAND());
		psmt.setString(3, message.getDESCRIPTION());
		psmt.setString(4, message.getCONTENT());
		psmt.execute();
		close();
		return true;
	}

	@Override
	public boolean update(Message message) throws SQLException {
		connection = DbcpUtil.getConnection();
		String sql = "UPDATE MESSAGE SET ID = ? ,COMMAND =? ,DESCRIPTION = ?,CONTENT = ? WHERE ID = ?";
		psmt = connection.prepareStatement(sql);
		psmt.setInt(1, message.getID());
		psmt.setString(2, message.getCOMMAND());
		psmt.setString(3, message.getDESCRIPTION());
		psmt.setString(4, message.getCONTENT());
		psmt.setInt(5, message.getID());
		psmt.execute();
		close();
		return true;
	}

	@Override
	public boolean delete(Message message) throws SQLException {
		connection = DbcpUtil.getConnection();
		String sql = "DELETE FROM MESSAGE WHERE ID = ?";
		psmt = connection.prepareStatement(sql);
		psmt.setInt(1, message.getID());
		psmt.execute();
		close();
		return true;
	}

	/**
	 * 释放资源
	 * 
	 * @return
	 * @throws SQLException
	 */
	private boolean close() throws SQLException {
		if (rs != null) {
			rs.close();
			rs = null;
		}
		if (psmt != null) {
			psmt.close();
			psmt = null;
		}
		return true;
	}

	@Override
	public List<Message> queryMessageByParams(String command, String description) throws SQLException {
		connection = DbcpUtil.getConnection();
		List<Message> result = new ArrayList<>();
		List<String> list = new ArrayList<>();
		StringBuffer sql = new StringBuffer();
		sql.append("select id,command,description,content from message where 1=1 ");

		if (command != null && !"".equals(command)) {
			sql.append("and command = ?  ");
			list.add(command);
		}

		if (description != null && !"".equals(description)) {
			sql.append("and description like '%'?'%' ");
			list.add(command);
		}

		psmt = connection.prepareStatement(sql.toString());
		for (int i = 0; i < list.size(); i++) {
			psmt.setString(i + 1, list.get(i));
		}
		rs = psmt.executeQuery();
		while (rs.next()) {
			Message message = new Message();
			message.setID(rs.getInt("ID"));
			message.setCOMMAND(rs.getString("COMMAND"));
			message.setCONTENT("CONTENT");
			message.setDESCRIPTION(rs.getString("DESCRIPTION"));
			result.add(message);
		}
		close();
		return result;
	}
}
