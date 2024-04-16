package com.zktr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.UeasDAO;

/**
 * Servlet implementation class XGuserServlet
 */
@WebServlet("/view/XGuserServlet")
public class XGuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UeasDAO uu=new UeasDAO();
		int id=Integer.parseInt(request.getParameter("id"));
		String yhm=request.getParameter("z_uname");
		String sex=request.getParameter("z_esx");
		String phone=request.getParameter("z_phone");
		int state=Integer.parseInt(request.getParameter("z_state"));
		uu.xg(yhm,sex,phone,state,id);
		request.getRequestDispatcher("user").forward(request, response);
	}
}
