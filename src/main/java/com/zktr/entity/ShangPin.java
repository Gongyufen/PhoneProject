package com.zktr.entity;

import java.util.Date;

public class ShangPin {
	private int c_did;
	private int c_mid;
	private int c_cid;
	private Date c_dtime;
	private String c_describe;
	private int c_dstate;
	public int getC_did() {
		return c_did;
	}
	public void setC_did(int c_did) {
		this.c_did = c_did;
	}
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
	public Date getC_dtime() {
		return c_dtime;
	}
	public void setC_dtime(Date c_dtime) {
		this.c_dtime = c_dtime;
	}
	public String getC_describe() {
		return c_describe;
	}
	public void setC_describe(String c_describe) {
		this.c_describe = c_describe;
	}
	public int getC_dstate() {
		return c_dstate;
	}
	public void setC_dstate(int c_dstate) {
		this.c_dstate = c_dstate;
	}
	public ShangPin(int c_did, int c_mid, int c_cid, Date c_dtime, String c_describe, int c_dstate) {
		super();
		this.c_did = c_did;
		this.c_mid = c_mid;
		this.c_cid = c_cid;
		this.c_dtime = c_dtime;
		this.c_describe = c_describe;
		this.c_dstate = c_dstate;
	}
	public ShangPin() {
		super();
	}
	public ShangPin(int c_did) {
		super();
		this.c_did = c_did;
	}
	public ShangPin(int c_did, int c_mid) {
		super();
		this.c_did = c_did;
		this.c_mid = c_mid;
	}
	
}
