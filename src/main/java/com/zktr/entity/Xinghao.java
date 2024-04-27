package com.zktr.entity;

public class Xinghao {
	private int c_mid;
	private int c_cid;
	private String c_mname;
	public int getC_mid() {
		return c_mid;
	}
	public void setC_mid(int c_mid) {
		this.c_mid = c_mid;
	}
	public int getC_cid() {
		return c_cid;
	}
	public void setC_cid(int c_cid) {
		this.c_cid = c_cid;
	}
	public String getC_mname() {
		return c_mname;
	}
	public void setC_mname(String c_mname) {
		this.c_mname = c_mname;
	}
	public Xinghao(int c_mid, int c_cid, String c_mname) {
		super();
		this.c_mid = c_mid;
		this.c_cid = c_cid;
		this.c_mname = c_mname;
	}
	public Xinghao() {
		super();
	}
	public Xinghao(int c_mid) {
		super();
		this.c_mid = c_mid;
	}
	
}
