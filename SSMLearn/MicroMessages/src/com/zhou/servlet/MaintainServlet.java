package com.zhou.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhou.service.MaintainService;
import com.zhou.service.Service;

public class MaintainServlet extends HttpServlet {

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
		String action = req.getParameter("action");
		Service service = new MaintainService();
		try {
			if ("deleteone".equals(action)) {
				String id = req.getParameter("id");
				((MaintainService) service).deleteOne(id);
			} else if ("deletebatch".equals(action)) {
				String[] ids = req.getParameterValues("ids");
				((MaintainService) service).deleteBatch(ids);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("list.action").forward(req, resp);
	}
}
