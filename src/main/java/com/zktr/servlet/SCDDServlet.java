package com.zktr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.DingdanDAO;

/**
 * Servlet implementation class SCDDServlet
 */
@WebServlet("/view/SCDDServlet")
public class SCDDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DingdanDAO dd=new DingdanDAO();
		int id=Integer.parseInt(request.getParameter("id"));
		dd.sc(id);
		request.getRequestDispatcher("dingdan").forward(request, response);
	}
}
