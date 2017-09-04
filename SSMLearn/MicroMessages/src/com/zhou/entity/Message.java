package com.zhou.entity;

/**
 * 消息实体类
 * 
 * @author zhou
 *
 */
public class Message {
	private int ID;// ID号
	private String COMMAND;// 命令类型
	private String DESCRIPTION;// 描述
	private String CONTENT;// 内容

	public Message() {
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCOMMAND() {
		return COMMAND;
	}

	public void setCOMMAND(String cOMMAND) {
		COMMAND = cOMMAND;
	}

	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}

	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	
	/*@Override
	public String toString() {
		return ID+"-"+COMMAND+"-"+DESCRIPTION+"-"+CONTENT;
	}*/

}
