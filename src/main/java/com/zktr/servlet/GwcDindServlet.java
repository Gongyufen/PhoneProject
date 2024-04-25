package com.zktr.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
 * Servlet implementation class GwcDindServlet
 */
@WebServlet("/view/GwcDindServlet")
public class GwcDindServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("UTF-8");
		 GouwucheDAO gouwucheDAO=new GouwucheDAO();
		 IndentDAO indentDAO=new IndentDAO();
		 int uid=Integer.parseInt(request.getSession().getAttribute("id").toString());
		 String sid[]=request.getParameterValues("arr")[0].split(",");
		 List<Gwc> list=new ArrayList();
		 for(int i=0;i<sid.length;i++) {
			 list.add( gouwucheDAO.selectsid(sid[i]).get(0));
			gouwucheDAO.delete(Integer.parseInt(sid[i]));
		 }
		 indentDAO.xzDd(uid);
		 for(int i=0;i<list.size();i++) {
			 indentDAO.insertDdXq(uid,list.get(i).getRid(),list.get(i).getYsid(),list.get(i).getNcid(),list.get(i).getXh(),list.get(i).getSsl(),list.get(i).getZj(),list.get(i).getMid());
		 }
		 request.getRequestDispatcher("QrDindanServlet").forward(request, response);
	}

}
