package com.zktr.entity;

public class Gwc {
	private int sid;
	private int did;
	private int mid;
	private int rid;
	private int ysid;
	private int ncid;
	private int ssl;
	private int uid;
	
	private String xh;
	private double zj;
	
	
	
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public double getZj() {
		return zj;
	}
	public void setZj(double zj) {
		this.zj = zj;
	}
	public Gwc(int sid, int did, int mid, int rid, int ysid, int ncid, int ssl, int uid) {
		super();
		this.sid = sid;
		this.did = did;
		this.mid = mid;
		this.rid = rid;
		this.ysid = ysid;
		this.ncid = ncid;
		this.ssl = ssl;
		this.uid = uid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getYsid() {
		return ysid;
	}
	public void setYsid(int ysid) {
		this.ysid = ysid;
	}
	public int getNcid() {
		return ncid;
	}
	public void setNcid(int ncid) {
		this.ncid = ncid;
	}
	public int getSsl() {
		return ssl;
	}
	public void setSsl(int ssl) {
		this.ssl = ssl;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
}
