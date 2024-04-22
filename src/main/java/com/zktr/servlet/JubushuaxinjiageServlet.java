package com.zktr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.alibaba.fastjson2.JSONArray;

import com.zktr.dao.JiageDAO;
import com.zktr.entity.Jiage;

/**
 * Servlet implementation class JubushuaxinjiageServlet
 */
@WebServlet("/view/JubushuaxinjiageServlet")
public class JubushuaxinjiageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		JiageDAO jiageDAO=new JiageDAO();
		int ysid=Integer.parseInt(request.getParameter("ysid"));
		int ncid=Integer.parseInt(request.getParameter("ncid"));
		List<Jiage> list=jiageDAO.guige(ysid,ncid);
		String array=JSONArray.toJSONString(list);
		System.out.println(array);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(array);
	}

}
