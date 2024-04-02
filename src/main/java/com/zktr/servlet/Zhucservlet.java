package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.UeasDAO;

/**
 * Servlet implementation class Zhucservlet
 */
@WebServlet("/view/Zhucservlet")
public class Zhucservlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		UeasDAO ueasDAO=new UeasDAO();
		if(ueasDAO.judge(request.getParameter("name"))) {
			System.out.println(request.getParameter("name"));
			ueasDAO.insert(request.getParameter("name"),
					request.getParameter("pas"),
					request.getParameter("sex"),
					request.getParameter("phone")
					);
			request.setAttribute("pd","注册成功");
			request.getRequestDispatcher("denglu.jsp").forward(request, response);
		}else {
			request.setAttribute("pd","注册失败");
			request.getRequestDispatcher("denglu.jsp").forward(request, response);
		}
	}

}
