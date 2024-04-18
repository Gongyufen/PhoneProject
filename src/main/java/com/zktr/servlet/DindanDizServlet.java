package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.IndentDAO;

/**
 * Servlet implementation class DindanDizServlet
 */
@WebServlet("/view/DindanDizServlet")
public class DindanDizServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		IndentDAO indentDAO=new IndentDAO();
		int id=Integer.parseInt(request.getParameter("id"));
		indentDAO.xgDdDz(request.getParameter("name"),request.getParameter("shen")+"-"+request.getParameter("shi")+"-"+request.getParameter("qu")+"-"+request.getParameter("xxdiz"),request.getParameter("phone"),id);
		request.getRequestDispatcher("DindanXqServlet?iid="+id).forward(request, response);
	}
}
