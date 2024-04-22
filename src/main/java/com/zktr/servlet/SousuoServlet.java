package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.ProductDAO;

/**
 * Servlet implementation class Sousuo
 */
@WebServlet(urlPatterns = "/view/sousuo")
public class SousuoServlet extends HttpServlet {
	private ProductDAO sousuo = new ProductDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		String value=request.getParameter("value");
		request.setAttribute("sousuo", sousuo.leibieming(value));
		request.getRequestDispatcher("/view/sousuo.jsp").forward(request, response);
	}

}
