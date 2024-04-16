package com.zktr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.UeasDAO;

/**
 * Servlet implementation class SCuserServlet
 */
@WebServlet("/view/SCuserServlet")
public class SCuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UeasDAO uu=new UeasDAO();
		int id=Integer.parseInt(request.getParameter("id"));
		uu.delete(id);
		request.getRequestDispatcher("user").forward(request, response);
	}

}
