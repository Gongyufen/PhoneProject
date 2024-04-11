package com.zktr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.UeasDAO;

/**
 * Servlet implementation class XgMm
 */
@WebServlet("/view/XgMm")
public class XgMmServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		UeasDAO ueasDAO=new UeasDAO();
		if (ueasDAO.xgPas(request.getParameter("xin"),request.getParameter("lao"),Integer.parseInt(request.getParameter("id")))==1) {
			 
			  out.print("<html>");
			  	out.print("<body>");
			  		out.print("<script>");
			  			
			  			out.print("setTimeout(function() {\r\n"
			  					+ "        window.location.href = \"denglu.jsp\";\r\n"
			  					+ "    }, 3000);");
			  		out.print("</script>");
			  		out.print("修改成功，3秒后返回登录");
			  	out.print("</body>");
			  out.print("</html>");
		}else {
			out.print("修改失败，请确认原密码是否正确");
		}
	}

}
