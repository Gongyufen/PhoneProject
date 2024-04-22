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
import javax.servlet.http.HttpSession;

import com.zktr.dao.ShangPinDAO;

/**
 * Servlet implementation class ChaShangPinServlet
 */
@WebServlet("/view/ChaShangPinServlet")
public class ChaShangPinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		ShangPinDAO ss=new ShangPinDAO();
		String rq=request.getParameter("rq");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 修改为你的日期格式
		Date date = null;
		try {
			date = dateFormat.parse(rq);
			int zt=Integer.parseInt(request.getParameter("zt"));
			if(ss.select(date, zt).size()!=0) {
				session.setAttribute("list",ss.select(date, zt));
				session.setAttribute("id",ss.select(date, zt).get(0).getC_did());
				request.getRequestDispatcher("shangpin.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("shangpin.jsp").forward(request, response);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
