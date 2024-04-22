package com.zktr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zktr.dao.GuigeDAO;

/**
 * Servlet implementation class ChaGuigeServlet
 */
@WebServlet("/view/ChaGuigeServlet")
public class ChaGuigeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String mc=request.getParameter("mc");
		GuigeDAO gg=new GuigeDAO();
		if(gg.select(mc).size()!=0) {
			session.setAttribute("list",gg.select(mc));
			session.setAttribute("id",gg.select(mc).get(0).getC_aid());
			request.getRequestDispatcher("guige.jsp").forward(request, response);
		}
	}

}
