package com.zktr.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.ShangPinDAO;

/**
 * Servlet implementation class CRShangpinServlet
 */
@WebServlet("/view/CRShangpinServlet")
public class CRShangpinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ShangPinDAO ss=new ShangPinDAO();
		int xh=Integer.parseInt(request.getParameter("xh"));
		int lb=Integer.parseInt(request.getParameter("lb"));
		String sj=request.getParameter("sj");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 根据实际情况修改日期格式
		try {
			Date date = sdf.parse(sj);
			String ms=request.getParameter("ms");
			int zt=Integer.parseInt(request.getParameter("zt"));
			int ii=Integer.parseInt(request.getParameter("ii"));
			request.setAttribute("xinh",ii);
			ss.cr(ii,xh, lb, date, ms, zt);
			request.getRequestDispatcher("ggtj.jsp").forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
