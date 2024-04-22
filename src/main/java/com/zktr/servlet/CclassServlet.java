package com.zktr.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.CclassDAO;
import com.zktr.dao.ModelDAO;
import com.zktr.dao.ProductDAO;
import com.zktr.entity.Cclass;
import com.zktr.entity.Product;

/**
 * Servlet implementation class CclassServlet
 */
@WebServlet(urlPatterns = "/view/shouye")
public class CclassServlet extends HttpServlet {
	private CclassDAO cclass = new CclassDAO();
	private ModelDAO model = new ModelDAO();
	private ProductDAO product = new ProductDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("UTF-8");
		List<Cclass> query = cclass.query();
		request.setAttribute("cclass",query );
		for(int i=0;i<query.size();i++) {
			request.setAttribute("model"+i, model.query(query.get(i).getCid()));
		}
		List<List<Product>> list = new ArrayList<>();
		query.forEach(e->{
			list.add(product.xinxi(e.getCid()));
		});
		request.setAttribute("product", list);
		
		request.getRequestDispatcher("shouye.jsp").forward(request, response);
	}

}
