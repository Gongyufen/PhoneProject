package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.CclassDAO;
import com.zktr.dao.IndentDAO;
import com.zktr.dao.JiageDAO;
import com.zktr.dao.ModelDAO;
import com.zktr.dao.ZaddressDAO;

/**
 * Servlet implementation class QrDindanServlet
 */
@WebServlet("/view/QrDindanServlet")
public class QrDindanServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		IndentDAO indentDAO=new IndentDAO();
		CclassDAO cclassDAO=new CclassDAO();
		JiageDAO jiageDAO=new JiageDAO();
		ZaddressDAO zaddressDAO=new ZaddressDAO();
		int mid=Integer.parseInt(request.getParameter("mid"));
		int rid=Integer.parseInt(request.getParameter("rid"));
		int num=Integer.parseInt(request.getParameter("num"));
		int uid=Integer.parseInt(request.getSession().getAttribute("id").toString());
		indentDAO.xzDd(uid);
		indentDAO.insertDdXq(uid,rid,cclassDAO.select(mid).get(0).getCategory(),num,jiageDAO.jiaGe(rid).get(0).getC_rsprice()*num,mid);
		request.setAttribute("addDd",indentDAO.selectddxq(indentDAO.maxIid(uid).get(0)));
		request.setAttribute("dz",zaddressDAO.select(uid));
		request.getRequestDispatcher("qrdind.jsp").forward(request, response);
		
	}

}
