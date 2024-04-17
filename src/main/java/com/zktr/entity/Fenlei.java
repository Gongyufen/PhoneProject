package com.zktr.entity;

public class Fenlei {
	private int c_cid;
	private String c_category;
	public int getC_cid() {
		return c_cid;
	}
	public void setC_cid(int c_cid) {
		this.c_cid = c_cid;
	}
	public String getC_category() {
		return c_category;
	}
	public void setC_category(String c_category) {
		this.c_category = c_category;
	}
	public Fenlei(int c_cid, String c_category) {
		super();
		this.c_cid = c_cid;
		this.c_category = c_category;
	}
	public Fenlei() {
		super();
	}
	public Fenlei(int c_cid) {
		super();
		this.c_cid = c_cid;
	}
	
}
