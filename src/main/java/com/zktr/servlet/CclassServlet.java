package com.zktr.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.CclassDAO;
import com.zktr.dao.ModelDAO;
import com.zktr.dao.ProductDAO;
import com.zktr.entity.Cclass;

/**
 * Servlet implementation class CclassServlet
 */
@WebServlet(urlPatterns = "/webapp/shouye")
public class CclassServlet extends HttpServlet {
	private CclassDAO cclass = new CclassDAO();
	private ModelDAO model = new ModelDAO();
	private ProductDAO product = new ProductDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cclass", cclass.query());
		request.setAttribute("product", product.xinxi());
		for(int i=0;i<cclass.query().size();i++) {
			request.setAttribute("model"+i, model.query(cclass.query().get(i).getCid()));
		}
		request.getRequestDispatcher("/view/shouye.jsp").forward(request, response);
	}

}
