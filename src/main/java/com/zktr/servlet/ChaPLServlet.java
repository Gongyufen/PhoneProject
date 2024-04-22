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

import com.zktr.dao.PinglunDAO;

/**
 * Servlet implementation class ChaPLServlet
 */
@WebServlet("/view/ChaPLServlet")
public class ChaPLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PinglunDAO pp=new PinglunDAO();
		HttpSession session=request.getSession();
		String rq=request.getParameter("rq");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date date;
		try {
			date = sdf.parse(rq);
			Timestamp timestamp = new Timestamp(date.getTime());
			int dj=Integer.parseInt(request.getParameter("dj"));
			if(pp.select(timestamp, dj).size()!=0) {
				session.setAttribute("list",pp.select(timestamp, dj));
				session.setAttribute("id",pp.select(timestamp, dj).get(0).getZ_cid());
				request.getRequestDispatcher("pinglun.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("pinglun.jsp").forward(request, response);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
