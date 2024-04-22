package com.zktr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.FenleiDAO;

/**
 * Servlet implementation class SCflServlet
 */
@WebServlet("/view/SCflServlet")
public class SCflServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FenleiDAO ff=new FenleiDAO();
		int id=Integer.parseInt(request.getParameter("id"));
		ff.delete(id);
		request.getRequestDispatcher("fenlei").forward(request, response);
	}

}
