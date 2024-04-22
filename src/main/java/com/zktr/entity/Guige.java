package com.zktr.entity;

public class Guige {
	private int c_aid;
	private String c_aname;
	private int c_did;
	public int getC_aid() {
		return c_aid;
	}
	public void setC_aid(int c_aid) {
		this.c_aid = c_aid;
	}
	public String getC_aname() {
		return c_aname;
	}
	public void setC_aname(String c_aname) {
		this.c_aname = c_aname;
	}
	public int getC_did() {
		return c_did;
	}
	public void setC_did(int c_did) {
		this.c_did = c_did;
	}
	public Guige(int c_aid, String c_aname, int c_did) {
		super();
		this.c_aid = c_aid;
		this.c_aname = c_aname;
		this.c_did = c_did;
	}
	public Guige() {
		super();
	}
	public Guige(int c_aid) {
		super();
		this.c_aid = c_aid;
	}
	
}
