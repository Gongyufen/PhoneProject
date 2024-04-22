package com.zktr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.ShangPinDAO;
import com.zktr.entity.ShangPin;

/**
 * Servlet implementation class ShangPinServlet
 */
@WebServlet("/view/shangpin")
public class ShangPinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ShangPinDAO dd=new ShangPinDAO();
		List<ShangPin>list=dd.selectAll();
		request.setAttribute("list",list);
		request.getRequestDispatcher("shangpin.jsp").forward(request, response);
	}

}
