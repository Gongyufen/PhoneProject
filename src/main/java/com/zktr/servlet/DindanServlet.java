package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.IndentDAO;

/**
 * Servlet implementation class DindanServlet
 */
@WebServlet("/view/DindanServlet")
public class DindanServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("UTF-8");
		IndentDAO indentDAO=new IndentDAO();
		int id=Integer.parseInt(request.getSession().getAttribute("id").toString());
		if(request.getParameter("zt")==null) {
			request.setAttribute("ddlist",indentDAO.selectdd(id));
		}else {
			request.setAttribute("ddlist",indentDAO.selectdd(id,request.getParameter("zt")));
		}
		request.getRequestDispatcher("grzx/dindan.jsp").forward(request, response);
	}

}
