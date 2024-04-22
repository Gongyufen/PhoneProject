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

import com.zktr.dao.DingdanDAO;

/**
 * Servlet implementation class XGDDServlet
 */
@WebServlet("/view/XGDDServlet")
public class XGDDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		DingdanDAO dd=new DingdanDAO();
		int id=Integer.parseInt(request.getParameter("id"));
		String rq=request.getParameter("rq");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date date;
		try {
			date = sdf.parse(rq);
			Timestamp timestamp = new Timestamp(date.getTime());
			String zt=request.getParameter("zt");
			String shr=request.getParameter("shr");
			String dz=request.getParameter("dz");
			String sj=request.getParameter("sj");
			dd.xg(timestamp, zt, shr, dz, sj, id);
			request.getRequestDispatcher("dingdan").forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
