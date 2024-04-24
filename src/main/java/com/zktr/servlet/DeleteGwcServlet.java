package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.GouwucheDAO;

/**
 * Servlet implementation class DeleteGwcServlet
 */
@WebServlet("/view/DeleteGwcServlet")
public class DeleteGwcServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GouwucheDAO gouwucheDAO=new GouwucheDAO();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		int sid=Integer.parseInt(request.getParameter("sid"));
		gouwucheDAO.delete(sid);
		request.getRequestDispatcher("GouwucheServlet").forward(request, response);
	}
}
