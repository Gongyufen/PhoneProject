package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.ZcommentDAO;

/**
 * Servlet implementation class PinglunServlet
 */
@WebServlet("/view/PinglunServlet")
public class PinglunServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		ZcommentDAO zcommentDAO=new ZcommentDAO();
		int uid=Integer.parseInt(request.getSession().getAttribute("id").toString());
		int pj=Integer.parseInt(request.getParameter("pj"));
		int did=Integer.parseInt(request.getParameter("did").trim());
		int iid=Integer.parseInt(request.getParameter("iid"));
		zcommentDAO.insert(request.getParameter("message"),pj,uid,did);
		request.getRequestDispatcher("DindanXqServlet?iid="+iid).forward(request, response);
	}
}
