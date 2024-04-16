package com.zktr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zktr.dao.UeasDAO;

/**
 * Servlet implementation class ChaServlet
 */
@WebServlet("/view/ChaServlet")
public class ChaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UeasDAO uu=new UeasDAO();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String yhm=request.getParameter("yhm");
		String sj=request.getParameter("sj");
		int zt=Integer.parseInt(request.getParameter("zt"));
		if(uu.cha(yhm, sj, zt).size()!=0) {
			session.setAttribute("list",uu.cha(yhm, sj, zt));
			session.setAttribute("id",uu.cha(yhm, sj, zt).get(0).getZ_uid());
			request.getRequestDispatcher("user.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("user.jsp").forward(request, response);
		}
	}

}
