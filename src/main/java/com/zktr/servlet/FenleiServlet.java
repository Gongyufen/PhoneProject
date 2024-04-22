package com.zktr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.FenleiDAO;
import com.zktr.entity.Fenlei;

/**
 * Servlet implementation class FenleiServlet
 */
@WebServlet("/view/fenlei")
public class FenleiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		FenleiDAO ff=new FenleiDAO();
		List<Fenlei>list=ff.selectAll();
		request.setAttribute("list",list);
		request.getRequestDispatcher("fenlei.jsp").forward(request, response);
	}

}
