package com.zhou.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhou.dao.IMessageDAO;
import com.zhou.dao.MessageDAOImpl;
import com.zhou.entity.Message;

public class ListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Message> result = null;
		IMessageDAO dao = new MessageDAOImpl();
		try {
			result = dao.queryAllMessages();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HttpSession session = req.getSession();
		session.setAttribute("data", result);
		req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		IMessageDAO dao = new MessageDAOImpl();
		List<Message> result = null;
		try {
			result = dao.queryMessageByParams(command, description);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HttpSession session = req.getSession();
		session.setAttribute("data", result);
		req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, resp);
	}

}
