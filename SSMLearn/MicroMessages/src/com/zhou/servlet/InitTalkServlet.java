package com.zhou.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitTalkServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		/*String command = req.getParameter("command");
		String description = req.getParameter("description");
		Service service = new ListService();
		List<Message> result = null;
		try {
			result = ((ListService) service).queryMessageByParams(command, description);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HttpSession session = req.getSession();
		session.setAttribute("data", result);*/
		req.getRequestDispatcher("/WEB-INF/jsp/talk.jsp").forward(req, resp);
	}
}
