package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.ZaddressDAO;

/**
 * Servlet implementation class ShanchuDizServlet
 */
@WebServlet("/view/ShanchuDizServlet")
public class ShanchuDizServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ZaddressDAO zaddressDAO=new ZaddressDAO();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt( request.getParameter("id"));
		zaddressDAO.delete(id);
		request.getRequestDispatcher("SelectDizServlet").forward(request, response);
	}

}
