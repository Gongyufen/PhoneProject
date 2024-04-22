package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zktr.dao.IndentDAO;

/**
 * Servlet implementation class DindanDizServlet
 */
@WebServlet("/view/DindanDizServlet")
public class DindanDizServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		IndentDAO indentDAO=new IndentDAO();
		if (request.getParameter("num")==null) {
			int id=Integer.parseInt(request.getParameter("id"));
			indentDAO.xgDdDz(request.getParameter("name"),request.getParameter("shen")+"-"+request.getParameter("shi")+"-"+request.getParameter("qu")+"-"+request.getParameter("xxdiz"),request.getParameter("phone"),id);
			request.getRequestDispatcher("DindanXqServlet?iid="+id).forward(request, response);
		}else {
			int uid=Integer.parseInt(request.getSession().getAttribute("id").toString());
			double price=Double.parseDouble(request.getParameter("num"));
			System.out.println(request.getParameter("num"));
			indentDAO.okdd(price,request.getParameter("shname"),request.getParameter("shaddress"),request.getParameter("shphone"),uid);
			HttpSession session=request.getSession();
			request.getRequestDispatcher("DindanXqServlet?iid="+indentDAO.maxIid(uid).get(0)).forward(request, response);
		}
		
	}
}
