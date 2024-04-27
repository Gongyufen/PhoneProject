package com.zktr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.GuigeDAO;

/**
 * Servlet implementation class CRGuiGeServlet
 */
@WebServlet("/view/CRGuiGeServlet")
public class CRGuiGeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		GuigeDAO gg=new GuigeDAO();
		String mc=request.getParameter("mc");
		int bh=Integer.parseInt(request.getParameter("bh"));
		int dd=Integer.parseInt(request.getParameter("dd"));
		gg.cr(dd,mc, bh);
		request.setAttribute("dd",dd);
		request.getRequestDispatcher("ggxq.jsp").forward(request, response);
	}

}
