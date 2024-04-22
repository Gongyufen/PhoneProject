package com.zktr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.GuigexqDAO;

/**
 * Servlet implementation class SCGuigexqServlet
 */
@WebServlet("/view/SCGuigexqServlet")
public class SCGuigexqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuigexqDAO gg=new GuigexqDAO();
		int id=Integer.parseInt(request.getParameter("id"));
		gg.sc(id);
		request.getRequestDispatcher("guigexq").forward(request, response);
	}

}
