package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.CclassDAO;
import com.zktr.entity.Cclass;

/**
 * Servlet implementation class CclassServlet
 */
@WebServlet(urlPatterns = "/12/denglu")
public class CclassServlet extends HttpServlet {
	private CclassDAO cclass = new CclassDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cclass.query();
		request.setAttribute("cclass", cclass.query());
		request.getRequestDispatcher("denglu.jsp").forward(request, response);
	}

}
