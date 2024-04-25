package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.ZcommentDAO;

/**
 * Servlet implementation class DeleteplServlet
 */
@WebServlet("/view/DeleteplServlet")
public class DeleteplServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		ZcommentDAO zcommentDAO=new ZcommentDAO();
		int cid=Integer.parseInt(request.getParameter("cid"));
		zcommentDAO.delete(cid);
		request.getRequestDispatcher("CjakanPlServlet").forward(request, response);
	}

}
