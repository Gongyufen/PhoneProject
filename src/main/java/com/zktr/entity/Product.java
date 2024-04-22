package com.zktr.entity;

import java.sql.Timestamp;

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
	
	private int c_mid;//商品型号id
	private String c_aname;//规格名称
	
	private String c_gtails;
	
	private int c_rid;
	private int c_did;//商品详情id
	
	private int c_gid;
	
	
	public int getC_did() {
		return c_did;
	}

	public void setC_did(int c_did) {
		this.c_did = c_did;
	}

	public int getC_gid() {
		return c_gid;
	}

	public void setC_gid(int c_gid) {
		this.c_gid = c_gid;
	}

	public int getC_rid() {
		return c_rid;
	}

	public void setC_rid(int c_rid) {
		this.c_rid = c_rid;
	}

	public String getC_gtails() {
		return c_gtails;
	}

	public void setC_gtails(String c_gtails) {
		this.c_gtails = c_gtails;
	}

	public int getC_mid() {
		return c_mid;
	}

	public void setC_mid(int c_mid) {
		this.c_mid = c_mid;
	}

	public String getC_aname() {
		return c_aname;
	}

	public void setC_aname(String c_aname) {
		this.c_aname = c_aname;
	}

	
	
	//商品信息表
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
