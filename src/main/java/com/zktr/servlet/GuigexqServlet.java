package com.zktr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.GuigexqDAO;
import com.zktr.entity.Guigexq;

/**
 * Servlet implementation class GuigexqServlet
 */
@WebServlet("/view/guigexq")
public class GuigexqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		GuigexqDAO dd=new GuigexqDAO();
		List<Guigexq>list=dd.selectAll();
		request.setAttribute("list",list);
		request.getRequestDispatcher("guigexq.jsp").forward(request, response);
	}

}
