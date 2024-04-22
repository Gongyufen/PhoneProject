package com.zktr.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zktr.dao.ShangPinDAO;

@WebServlet("/view/XGShangpServlet")
public class XGShangpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ShangPinDAO ss=new ShangPinDAO();
        int id=Integer.parseInt(request.getParameter("id"));
        String rq=request.getParameter("rq");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse(rq);
            String ms=request.getParameter("ms");
            int zt=Integer.parseInt(request.getParameter("zt"));
            ss.xg(date, ms, zt, id);
            request.getRequestDispatcher("shangpin").forward(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("解析日期字符串出错： " + rq);
        }
    }
}