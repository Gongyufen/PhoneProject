package com.zktr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.XinghaoDAO;

/**
 * Servlet implementation class CRXinghaoServlet
 */
@WebServlet("/view/CRXinghaoServlet")
public class CRXinghaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		XinghaoDAO xx=new XinghaoDAO();
		int id=Integer.parseInt(request.getParameter("lb"));
		String spm=request.getParameter("spm");
		int xh=Integer.parseInt(request.getParameter("hiddenValue"));
		if(id!=0 && spm!=null) {
			xx.cr(xh,id, spm);
			request.setAttribute("xinh", id);
			request.getRequestDispatcher("sptj.jsp").forward(request, response);
		}
	}

}
