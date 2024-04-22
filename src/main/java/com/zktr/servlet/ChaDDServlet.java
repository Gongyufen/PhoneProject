package com.zktr.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zktr.dao.DingdanDAO;

/**
 * Servlet implementation class ChaDDServlet
 */
@WebServlet("/view/ChaDDServlet")
public class ChaDDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		DingdanDAO dd=new DingdanDAO();
		String rq=request.getParameter("rq");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date date;
		try {
			 date = sdf.parse(rq);
			 Timestamp timestamp = new Timestamp(date.getTime());
			 String zt=request.getParameter("zt");
				if(dd.select(timestamp, zt).size()!=0) {
					session.setAttribute("list",dd.select(timestamp, zt));
					session.setAttribute("id",dd.select(timestamp, zt).get(0).getZ_iid());
					request.getRequestDispatcher("dingdan.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("dingdan.jsp").forward(request, response);
				}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
