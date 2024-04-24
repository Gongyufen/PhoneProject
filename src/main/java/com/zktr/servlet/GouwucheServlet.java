package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.GouwucheDAO;

/**
 * Servlet implementation class GouwucheServlet
 */
@WebServlet("/view/GouwucheServlet")
public class GouwucheServlet extends HttpServlet {
		private GouwucheDAO gouwuche = new GouwucheDAO();
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("UTF-8");
			int uid=Integer.parseInt(request.getSession().getAttribute("id").toString());
			if(request.getParameter("mid")!=null) {
				int mid=Integer.parseInt(request.getParameter("mid"));
				int ysid=Integer.parseInt(request.getParameter("ysid"));
				int ncid=Integer.parseInt(request.getParameter("ncid"));
				int rid=Integer.parseInt(request.getParameter("rid"));
				int did=Integer.parseInt(request.getParameter("did"));
				int zhi=Integer.parseInt(request.getParameter("zhi"));
				request.setAttribute("zhi",zhi);
				gouwuche.gouwuchexinzeng(did, mid, ysid, ncid, rid, uid, zhi);
			}
			request.setAttribute("gwc", gouwuche.chaxun(uid));
			request.getRequestDispatcher("gouwuche.jsp").forward(request, response);
	}

}
