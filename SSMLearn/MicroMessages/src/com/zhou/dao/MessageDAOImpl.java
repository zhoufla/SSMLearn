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
		String sql = "select * from message";
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
		String sql = "select * from message where ID=?";
		psmt = connection.prepareStatement(sql);
		psmt.setInt(1, id);
		;
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
}
