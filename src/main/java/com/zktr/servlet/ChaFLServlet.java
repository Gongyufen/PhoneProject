package com.zktr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zktr.dao.FenleiDAO;

/**
 * Servlet implementation class ChaFLServlet
 */
@WebServlet("/view/ChaFLServlet")
public class ChaFLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FenleiDAO ff=new FenleiDAO();
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String lbm=request.getParameter("lbm");
		if(ff.select(lbm).size()!=0) {
			session.setAttribute("list",ff.select(lbm));
			session.setAttribute("id",ff.select(lbm).get(0).getC_cid());
			request.getRequestDispatcher("fenlei.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("fenlei.jsp").forward(request, response);
		}
	}

}
