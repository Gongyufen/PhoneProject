package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.IndentDAO;

/**
 * Servlet implementation class DindanServlet
 */
@WebServlet("/view/DindanServlet")
public class DindanServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("UTF-8");
		 int id=Integer.parseInt(request.getSession().getAttribute("id").toString());
		 int pagesize=3;
		 if (request.getParameter("pagesize")!=null) {
			pagesize=Integer.parseInt(request.getParameter("pagesize"));
		}
		 int curpage=1;
		 if (request.getParameter("curpage")!=null) {
			 curpage=Integer.parseInt(request.getParameter("curpage"));
			}
		IndentDAO indentDAO=new IndentDAO();
		String where="";
		if(request.getParameter("zt")!=null) {
			where="zt="+request.getParameter("zt");
			request.setAttribute("total",indentDAO.totel(id,request.getParameter("zt")).get(0));
			request.setAttribute("ddlist",indentDAO.selectdd(id,request.getParameter("zt"),((curpage-1)*pagesize),pagesize));
		}else {
			request.setAttribute("total",indentDAO.totel(id).get(0));
			request.setAttribute("ddlist",indentDAO.selectdd(id,((curpage-1)*pagesize),pagesize));
		}
			
			
		request.setAttribute("where",where);
			request.setAttribute("pagesize",pagesize);
			request.setAttribute("curpage",curpage);
			
		request.getRequestDispatcher("grzx/dindan.jsp").forward(request, response);
	}

}
