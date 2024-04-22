package com.zktr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zktr.dao.UeasDAO;

/**
 * Servlet implementation class DengluServlet
 */
@WebServlet("/view/DengluServlet")
public class DengluServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");
		 
		if (request.getParameter("grzx")!=null) {
				request.getRequestDispatcher("grzx/Personal Center Body.jsp").forward(request, response);
		}else {
				if (request.getParameter("name")!=null&&request.getParameter("pas")!=null) {
					String name=request.getParameter("name");
					String pas=request.getParameter("pas");
					UeasDAO usersdao = new UeasDAO();
					HttpSession session=request.getSession();
					PrintWriter out = response.getWriter();
					if (usersdao.select(name, pas).size()!=0) {
						session.setAttribute("list",usersdao.select(name,pas));
						System.out.println(usersdao.select(name,pas));
						session.setAttribute("id",usersdao.select(name,pas).get(0).getZ_uid());
						
					}else {
						request.setAttribute("pd","登陆失败");
						request.getRequestDispatcher("denglu.jsp").forward(request, response);
					}
				}
				request.getRequestDispatcher("shouye").forward(request, response);
		}
		
		
		
		
		
	}

}
