package com.zktr.entity;

/**
* @Description: 
* @author: ccy
* @date 2024年4月18日 下午2:20:23
*/
//规格详情值
public class Jiage {
	private int c_rid;
	private double c_rsprice;
	
	public Jiage(int c_rid, double c_rsprice) {
		super();
		this.c_rid = c_rid;
		this.c_rsprice = c_rsprice;
	}

	public Jiage() {
		super();
	}

	public int getC_rid() {
		return c_rid;
	}

	public void setC_rid(int c_rid) {
		this.c_rid = c_rid;
	}

	public double getC_rsprice() {
		return c_rsprice;
	}

	public void setC_rsprice(double c_rsprice) {
		this.c_rsprice = c_rsprice;
	}

	@Override
	public String toString() {
		return "JiageDAO [c_rid=" + c_rid + ", c_rsprice=" + c_rsprice + "]";
	}
	
	
	
}
