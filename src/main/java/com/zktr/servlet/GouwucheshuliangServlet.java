package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.GouwucheDAO;

/**
 * Servlet implementation class GouwucheshuliangServlet
 */
@WebServlet("/view/GouwucheshuliangServlet")
public class GouwucheshuliangServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GouwucheDAO gouwucheDAO=new GouwucheDAO();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		int ssl=Integer.parseInt(request.getParameter("ssl"));
		int sid=Integer.parseInt(request.getParameter("sid"));
		gouwucheDAO.jiajian(ssl, sid);
		request.getRequestDispatcher("GouwucheServlet").forward(request, response);
	}

}
