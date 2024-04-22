package com.zktr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.GuigeDAO;
import com.zktr.entity.Guige;

/**
 * Servlet implementation class GuigeServlet
 */
@WebServlet("/view/guige")
public class GuigeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		GuigeDAO dd=new GuigeDAO();
		List<Guige>list=dd.selectAll();
		request.setAttribute("list",list);
		request.getRequestDispatcher("guige.jsp").forward(request, response);
	}

}
