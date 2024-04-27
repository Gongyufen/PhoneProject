package com.zktr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.GuigexqDAO;

/**
 * Servlet implementation class CRGgxqServlet
 */
@WebServlet("/view/CRGgxqServlet")
public class CRGgxqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		GuigexqDAO ii=new GuigexqDAO();
		int xq=Integer.parseInt(request.getParameter("xq"));
		int gg=Integer.parseInt(request.getParameter("gg"));
		String ggxq=request.getParameter("ggxq");
		String lj=request.getParameter("lj");
		ii.cr(xq, gg, ggxq, lj);
		request.getRequestDispatcher("tjjg.jsp").forward(request, response);
	}

}
