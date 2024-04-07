package com.zktr.entity;

/**
* @Description: 
* @author: ccy
* @date 2024年4月7日 上午8:35:01
*/

public class Model {
	private int mid;
	private int cid;
	private String mname;
	
	public Model(int mid, int cid, String mname) {
		super();
		this.mid = mid;
		this.cid = cid;
		this.mname = mname;
	}
	public Model() {
		super();
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	@Override
	public String toString() {
		return "Model [mid=" + mid + ", cid=" + cid + ", mname=" + mname + "]";
	}
	
	
}
