package com.zktr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zktr.dao.GuigexqDAO;

/**
 * Servlet implementation class ChaGuigexqServlet
 */
@WebServlet("/view/ChaGuigexqServlet")
public class ChaGuigexqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		GuigexqDAO gg=new GuigexqDAO();
		String xq=request.getParameter("xq");
		if(gg.select(xq).size()!=0) {
			session.setAttribute("list",gg.select(xq));
			session.setAttribute("id",gg.select(xq).get(0).getC_gid());
			request.getRequestDispatcher("guigexq.jsp").forward(request, response);
		}
	}

}
