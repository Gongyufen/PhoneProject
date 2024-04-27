package com.zktr.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.GouwucheDAO;
import com.zktr.dao.IndentDAO;
import com.zktr.entity.Gwc;

/**
 * Servlet implementation class QuanxuanshanchuServlet
 */
@WebServlet("/view/QuanxuanshanchuServlet")
public class QuanxuanshanchuServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("UTF-8");
		 GouwucheDAO gouwucheDAO=new GouwucheDAO();
		 int uid=Integer.parseInt(request.getSession().getAttribute("id").toString());
		 String sid[]=request.getParameterValues("arr")[0].split(",");
		 for(int i=0;i<sid.length;i++) {
			gouwucheDAO.delete(Integer.parseInt(sid[i]));
		 }
		 request.getRequestDispatcher("GouwucheServlet").forward(request, response);
	}

}
