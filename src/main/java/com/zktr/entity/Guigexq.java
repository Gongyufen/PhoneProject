package com.zktr.entity;

public class Guigexq {
	private int c_gid;
	private int c_aid;
	private String c_gtails;
	private String c_groute;
	public int getC_gid() {
		return c_gid;
	}
	public void setC_gid(int c_gid) {
		this.c_gid = c_gid;
	}
	public int getC_aid() {
		return c_aid;
	}
	public void setC_aid(int c_aid) {
		this.c_aid = c_aid;
	}
	public String getC_gtails() {
		return c_gtails;
	}
	public void setC_gtails(String c_gtails) {
		this.c_gtails = c_gtails;
	}
	public String getC_groute() {
		return c_groute;
	}
	public void setC_groute(String c_groute) {
		this.c_groute = c_groute;
	}
	public Guigexq(int c_gid, int c_aid, String c_gtails, String c_groute) {
		super();
		this.c_gid = c_gid;
		this.c_aid = c_aid;
		this.c_gtails = c_gtails;
		this.c_groute = c_groute;
	}
	public Guigexq() {
		super();
	}
	public Guigexq(int c_gid) {
		super();
		this.c_gid = c_gid;
	}
	
}
