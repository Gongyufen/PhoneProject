package com.zktr.entity;

/**
* @Description: 
* @author: ccy
* @date 2024年4月7日 上午8:29:15
*/

public class Cclass{
	private int cid;
	private String category;
	
	public Cclass(int cid, String category) {
		super();
		this.cid = cid;
		this.category = category;
	}
	public Cclass() {
		super();
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Class [cid=" + cid + ", category=" + category + "]";
	}
	
	
}
