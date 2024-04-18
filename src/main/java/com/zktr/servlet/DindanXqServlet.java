package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.IndentDAO;

/**
 * Servlet implementation class DindanXqServlet
 */
@WebServlet("/view/DindanXqServlet")
public class DindanXqServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("iid"));
		IndentDAO indentDAO=new IndentDAO();
		request.setAttribute("ddxq",indentDAO.selectddxq(id));
		request.getRequestDispatcher("grzx/dindanxq.jsp").forward(request, response);
	}
}
