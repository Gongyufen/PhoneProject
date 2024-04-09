package com.zktr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.UeasDAO;
import com.zktr.entity.Ueas;

/**
 * Servlet implementation class UseaServlet
 */
@WebServlet("/view/user")
public class UseaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UeasDAO uu=new UeasDAO();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Ueas> list=uu.selectall();
		request.setAttribute("list",list);
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}

}
