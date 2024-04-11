package com.zktr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zktr.dao.ZaddressDAO;

/**
 * Servlet implementation class SelectDizServlet
 */
@WebServlet("/view/SelectDizServlet")
public class SelectDizServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(); 
		request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("UTF-8");
		ZaddressDAO zaddressDAO=new ZaddressDAO();
		request.setAttribute("dizlist",zaddressDAO.select(Integer.parseInt(session.getAttribute("id").toString())));
		request.getRequestDispatcher("grzx/dizgl.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(); 
		ZaddressDAO zaddressDAO=new ZaddressDAO();
		request.setAttribute("dizlist",zaddressDAO.select(Integer.parseInt(session.getAttribute("id").toString())));
		request.getRequestDispatcher("grzx/dizgl.jsp").forward(request, response);
	}
}
