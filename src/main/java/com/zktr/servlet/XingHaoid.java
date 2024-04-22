package com.zktr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.zktr.dao.ShangPinDAO;
import com.zktr.entity.ShangPin;

/**
 * Servlet implementation class XingHaoid
 */
@WebServlet("/view/XingHaoid")
public class XingHaoid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ShangPinDAO ss=new ShangPinDAO();
		 List<ShangPin> list=ss.selectid();
	     response.setContentType("application/json");
	     response.setCharacterEncoding("UTF-8");
	     response.getWriter().write(new Gson().toJson(list));
	}

}
