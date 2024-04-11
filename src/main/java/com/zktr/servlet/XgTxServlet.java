package com.zktr.servlet;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.zktr.dao.UeasDAO;


/**
 * Servlet implementation class XgTxServlet
 */
@WebServlet("/view/XgTxServlet")
@MultipartConfig
public class XgTxServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UeasDAO ueasDAO=new UeasDAO();
		request.setCharacterEncoding("utf-8");
			Part part=request.getPart("file");
			if(part!=null) {
				String name=part.getHeader("content-disposition");
				//文件名
				String name1= name.split(";")[2].split("=")[1].replaceAll("\"","");
				//文件后缀
				int pos=name1.lastIndexOf('.');
				String exl=name1.substring(pos);
				if(exl.equals(".png")||exl.equals(".JPG")||exl.equals(".JPEG")||exl.equals(".PNG")||exl.equals(".jpg")||exl.equals(".jpeg")) {
					//随机
					String rnname=UUID.randomUUID().toString().toUpperCase();
					//获取发布后的工程目录
					String root=this.getServletContext().getRealPath("");
					//创建images子文件夹
					File images=new File(root,"images");
					if(!images.exists()) {
						images.mkdirs();
					}
					String photo=root+"/images/"+rnname+exl;
					part.write(photo);
					if(ueasDAO.xgTx("../images/"+rnname+exl,Integer.parseInt(request.getParameter("id")))>0) {
						request.setAttribute("ok","修改成功");
						HttpSession session=request.getSession();
						session.setAttribute("list",ueasDAO.select(Integer.parseInt(request.getParameter("id"))));
					}else {
						request.setAttribute("ok","修改失败");
					}
					
				}else {
					request.setAttribute("ok","图片格式不支持");
				}
				request.getRequestDispatcher("grzx/Personal Center Body.jsp").forward(request, response);
			
		}
	}

}
