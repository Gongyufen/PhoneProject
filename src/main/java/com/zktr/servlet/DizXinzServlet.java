package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zktr.dao.ZaddressDAO;

/**
 * Servlet implementation class DizXinzServlet
 */
@WebServlet("/view/DizXinzServlet")
public class DizXinzServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession(); 
		response.setCharacterEncoding("UTF-8");
		ZaddressDAO zaddressDAO=new ZaddressDAO();
		String diz=request.getParameter("shen")+"-"+request.getParameter("shi")+"-"+request.getParameter("qu")+"-"+request.getParameter("xxdiz");
		zaddressDAO.insert(Integer.parseInt(session.getAttribute("id").toString()),
					diz,
					request.getParameter("name"),
					request.getParameter("phone")
				);
		request.getRequestDispatcher("SelectDizServlet").forward(request, response);
	}

}
