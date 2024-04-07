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
 * Servlet implementation class XgnameServlet
 */
@WebServlet("/view/XgnameServlet")
public class XgnameServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		int id=Integer.parseInt(request.getParameter("id"));
		UeasDAO ueasDAO=new UeasDAO();
		if (ueasDAO.judge(request.getParameter("name"))) {
			
			ueasDAO.xgName(request.getParameter("name"),id);
			request.setAttribute("cf","修改成功");
			session.setAttribute("list",ueasDAO.select(id));
			request.getRequestDispatcher("grzx/Personal Center Body.jsp").forward(request, response);
			
			
		}else {
			request.setAttribute("cf","该用户名以存在");
			session.setAttribute("list",ueasDAO.select(id));
			request.getRequestDispatcher("grzx/Personal Center Body.jsp").forward(request, response);

		}
	}

}
