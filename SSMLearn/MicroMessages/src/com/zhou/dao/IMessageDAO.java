package com.zhou.dao;

import java.sql.SQLException;
import java.util.List;

import com.zhou.entity.Message;

/**
 * 数据库DAO接口
 * 
 * @author zhou
 *
 */
public interface IMessageDAO {
	/**
	 * 查询所有信息
	 * 
	 * @return
	 */
	public List<Message> queryAllMessages() throws SQLException;

	/**
	 * 根据ID查询信息
	 * 
	 * @param id
	 * @return
	 */
	public Message queryMessageById(int id) throws SQLException;

	/**
	 * 根据信息查询Message
	 * 
	 * @param command
	 * @param description
	 * @return
	 * @throws SQLException
	 */
	public List<Message> queryMessageByParams(String command, String description) throws SQLException;

	/**
	 * 新增
	 * 
	 * @param message
	 * @return
	 */
	public boolean insert(Message message) throws SQLException;

	/**
	 * 修改
	 * 
	 * @param message
	 * @return
	 */
	public boolean update(Message message) throws SQLException;

	/**
	 * 删除
	 * 
	 * @param Id
	 * @return
	 */
	public boolean delete(int Id) throws SQLException;

	/**
	 * 批量删除
	 * @param list
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteBatch(List<Integer> list) throws SQLException;

}
