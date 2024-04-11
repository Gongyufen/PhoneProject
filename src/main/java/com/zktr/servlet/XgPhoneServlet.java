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
 * Servlet implementation class XgPhoneServlet
 */
@WebServlet("/view/XgPhoneServlet")
public class XgPhoneServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		UeasDAO ueasDAO=new UeasDAO();
		int id=Integer.parseInt(request.getParameter("id"));
		ueasDAO.xgPhone(request.getParameter("phone"),id);
		request.setAttribute("cf","修改成功");
		session.setAttribute("list",ueasDAO.select(id));
		request.getRequestDispatcher("grzx/Personal Center Body.jsp").forward(request, response);
	}

}
