package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.ProductDAO;
import com.zktr.dao.ZrecordDAO;

/**
 * Servlet implementation class XiangqingServlet
 */
@WebServlet("/view/XiangqingServlet")
public class XiangqingServlet extends HttpServlet {
	private ProductDAO xiangqing = new ProductDAO();
	private ZrecordDAO zrecordDAO=new ZrecordDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		
		int mid=Integer.parseInt(request.getParameter("mid"));
		//添加到浏览记录表
		if (request.getSession().getAttribute("id")!=null) {
			int uid=Integer.parseInt(request.getSession().getAttribute("id").toString());
			zrecordDAO.insert(uid,mid);
		}
	
		
		request.setAttribute("product", xiangqing.xiangqing(mid));
		request.setAttribute("guige", xiangqing.xqguige(mid));
		request.getRequestDispatcher("xiangqing.jsp").forward(request, response);
	}

}
