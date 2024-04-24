package com.zktr.entity;

/**
* @Description: 
* @author: ccy
* @date 2024年4月19日 上午10:01:12
*/

public class Gouwuche {
	private int c_sid;//购物车id
	
	public int getC_sid() {
		return c_sid;
	}



	public void setC_sid(int c_sid) {
		this.c_sid = c_sid;
	}
	private String c_groute;//图片
	private String c_mname;//商品名称
	private String c_ysgtails;//规格值颜色
	private String c_ncgtails;//规格值内存
	private double c_rsprice;//商品单价

	private int c_mid;//型号id
	private int c_rid;//价格id
	
	private int c_ssl;//数量
	
	
	
	
	public Gouwuche(String c_groute, String c_mname, String c_ysgtails, double c_rsprice, int c_mid, int c_rid,
			int c_ssl) {
		super();
		this.c_groute = c_groute;
		this.c_mname = c_mname;
		this.c_ysgtails = c_ysgtails;
		this.c_rsprice = c_rsprice;
		this.c_mid = c_mid;
		this.c_rid = c_rid;
		this.c_ssl = c_ssl;
	}



	public int getC_ssl() {
		return c_ssl;
	}



	public void setC_ssl(int c_ssl) {
		this.c_ssl = c_ssl;
	}



	public int getC_rid() {
		return c_rid;
	}

	public void setC_rid(int c_rid) {
		this.c_rid = c_rid;
	}

	public int getC_mid() {
		return c_mid;
	}
	public void setC_mid(int c_mid) {
		this.c_mid = c_mid;
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
	public String getC_ysgtails() {
		return c_ysgtails;
	}
	public void setC_ysgtails(String c_ysgtails) {
		this.c_ysgtails = c_ysgtails;
	}
	public String getC_ncgtails() {
		return c_ncgtails;
	}
	public void setC_ncgtails(String c_ncgtails) {
		this.c_ncgtails = c_ncgtails;
	}
	public double getC_rsprice() {
		return c_rsprice;
	}
	public void setC_rsprice(double c_rsprice) {
		this.c_rsprice = c_rsprice;
	}
	
	
}
