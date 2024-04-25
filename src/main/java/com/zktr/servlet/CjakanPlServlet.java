package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.ZcommentDAO;

/**
 * Servlet implementation class CjakanPlServlet
 */
@WebServlet("/view/CjakanPlServlet")
public class CjakanPlServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		ZcommentDAO zcommentDAO=new ZcommentDAO();
		int uid=Integer.parseInt(request.getSession().getAttribute("id").toString());
		request.setAttribute("pllst",zcommentDAO.selectuid(uid));
		request.getRequestDispatcher("grzx/pinglun.jsp").forward(request, response);
	}


}
