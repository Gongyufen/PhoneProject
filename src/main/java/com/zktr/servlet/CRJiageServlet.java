package com.zktr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.JiageDAO;

/**
 * Servlet implementation class CRJiageServlet
 */
@WebServlet("/view/CRJiageServlet")
public class CRJiageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		JiageDAO jg=new JiageDAO();
		int jj=Integer.parseInt(request.getParameter("jj"));
		double dj=Double.parseDouble(request.getParameter("dj"));
		jg.cr(jj, dj);
		request.getRequestDispatcher("/view/shangpin").forward(request, response);
	}

}
