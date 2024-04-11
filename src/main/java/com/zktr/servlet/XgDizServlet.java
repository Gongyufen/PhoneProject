package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.ZaddressDAO;

/**
 * Servlet implementation class XgDizServlet
 */
@WebServlet("/view/XgDizServlet")
public class XgDizServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		ZaddressDAO zaddressDAO=new ZaddressDAO();
		String diz=request.getParameter("shen")+"-"+request.getParameter("shi")+"-"+request.getParameter("qu")+"-"+request.getParameter("xxdiz");
		int id=Integer.parseInt(request.getParameter("id"));
		zaddressDAO.update(id,diz,request.getParameter("name"),request.getParameter("phone"));
		request.getRequestDispatcher("SelectDizServlet").forward(request, response);
	}

}
