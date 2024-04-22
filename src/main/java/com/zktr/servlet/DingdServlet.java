package com.zktr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.DingdanDAO;
import com.zktr.entity.Dingdan;

/**
 * Servlet implementation class DingdServlet
 */
@WebServlet("/view/dingdan")
public class DingdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		DingdanDAO dd=new DingdanDAO();
		List<Dingdan>list=dd.selectAll();
		request.setAttribute("list",list);
		request.getRequestDispatcher("dingdan.jsp").forward(request, response);
	}

}
