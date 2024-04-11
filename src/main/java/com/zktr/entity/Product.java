package com.zktr.entity;

/**
* @Description: 
* @author: ccy
* @date 2024年4月8日 下午4:37:44
*/

public class Product {
	private String c_groute;//图片
	private String c_mname;//商品名称
	private String c_describe;//商品描述
	private double c_rsprice;//商品价格
	
	public Product(String c_groute, String c_mname, String c_describe, double c_rsprice) {
		super();
		this.c_groute = c_groute;
		this.c_mname = c_mname;
		this.c_describe = c_describe;
		this.c_rsprice = c_rsprice;
	}

	public Product() {
		super();
	}

	public String getC_groute() {
		return c_groute;
	}

	public void setC_groute(String c_groute) {
		this.c_groute = c_groute;
	}

	public String getC_mname() {
		return c_mname;
	}

	public void setC_mname(String c_mname) {
		this.c_mname = c_mname;
	}

	public String getC_describe() {
		return c_describe;
	}

	public void setC_describe(String c_describe) {
		this.c_describe = c_describe;
	}

	public double getC_rsprice() {
		return c_rsprice;
	}

	public void setC_rsprice(double c_rsprice) {
		this.c_rsprice = c_rsprice;
	}

	@Override
	public String toString() {
		return "Product [c_groute=" + c_groute + ", c_mname=" + c_mname + ", c_describe=" + c_describe + ", c_rsprice="
				+ c_rsprice + "]";
	}
	
	
}
