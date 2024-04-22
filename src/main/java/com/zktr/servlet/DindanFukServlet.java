package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.IndentDAO;

/**
 * Servlet implementation class DindanFukServlet
 */
@WebServlet("/view/DindanFukServlet")
public class DindanFukServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("UTF-8");
		IndentDAO indentDAO=new IndentDAO();
		int uid=Integer.parseInt(request.getSession().getAttribute("id").toString());
		System.out.println(uid);
		int id=Integer.parseInt( request.getParameter("iid"));
		if(request.getParameter("cz").equals("确认收货")) {
			indentDAO.ddOk(id);
		}else if(request.getParameter("cz").equals("付款")){
			indentDAO.ddFk(id);
		}else if(request.getParameter("cz").equals("取消")) {
			indentDAO.scDdxq(id);
			indentDAO.scDd(id);
		}
		request.getRequestDispatcher("DindanServlet").forward(request, response);
	}
}
