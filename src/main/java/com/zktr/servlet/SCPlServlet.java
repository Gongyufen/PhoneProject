package com.zktr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.PinglunDAO;

/**
 * Servlet implementation class SCPlServlet
 */
@WebServlet("/view/SCPlServlet")
public class SCPlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PinglunDAO pp=new PinglunDAO();
		int id=Integer.parseInt(request.getParameter("id"));
		pp.sc(id);
		request.getRequestDispatcher("pinglun").forward(request, response);
	}

}
