package com.zktr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.FenleiDAO;

/**
 * Servlet implementation class XGflServlet
 */
@WebServlet("/view/XGflServlet")
public class XGflServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		FenleiDAO ff=new FenleiDAO();
		String idStr = request.getParameter("idd");
		String lbm = request.getParameter("lbm");
		int id=Integer.parseInt(idStr);
		ff.xg(lbm, id);
    	request.getRequestDispatcher("fenlei").forward(request, response);
	}

}
