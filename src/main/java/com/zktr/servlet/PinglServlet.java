package com.zktr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.PinglunDAO;
import com.zktr.entity.Pinglun;

/**
 * Servlet implementation class PinglServlet
 */
@WebServlet("/view/pinglun")
public class PinglServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PinglunDAO dd=new PinglunDAO();
		List<Pinglun>list=dd.selectAll();
		request.setAttribute("list",list);
		request.getRequestDispatcher("pinglun.jsp").forward(request, response);
	}

}
