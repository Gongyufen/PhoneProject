package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.ZrecordDAO;

/**
 * Servlet implementation class LljlServlet
 */
@WebServlet("/view/LljlServlet")
public class LljlServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("UTF-8");
		 int uid=Integer.parseInt( request.getSession().getAttribute("id").toString());
		 ZrecordDAO zrecordDAO=new ZrecordDAO();
		 request.setAttribute("lljllist",zrecordDAO.select(uid));
		request.getRequestDispatcher("lljl.jsp").forward(request, response);

	}

}
