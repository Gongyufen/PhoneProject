package com.zktr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.GuigeDAO;

/**
 * Servlet implementation class SCGuigeServlet
 */
@WebServlet("/view/SCGuigeServlet")
public class SCGuigeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuigeDAO ff=new GuigeDAO();
		int id=Integer.parseInt(request.getParameter("id"));
		ff.sc(id);
		request.getRequestDispatcher("guige").forward(request, response);
	}

}
