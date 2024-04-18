package com.zktr.entity;

public class Indent {
	private int z_iid;
	private String c_mname;
	private double c_rsprice;
	private int z_number;
	private String z_status;
	private double z_price;
	
	public Indent(int z_iid, String c_mname, double c_rsprice, int z_number, String z_status, double z_price) {
		super();
		this.z_iid = z_iid;
		this.c_mname = c_mname;
		this.c_rsprice = c_rsprice;
		this.z_number = z_number;
		this.z_status = z_status;
		this.z_price = z_price;
	}
	private String color;
	private String nc;
	private String tup;
	private double dindanzojia;
	private String z_consignee;
	private String z_address;
	private String z_phone;
	
	public String getZ_consignee() {
		return z_consignee;
	}
	public void setZ_consignee(String z_consignee) {
		this.z_consignee = z_consignee;
	}
	public String getZ_address() {
		return z_address;
	}
	public void setZ_address(String z_address) {
		this.z_address = z_address;
	}
	public String getZ_phone() {
		return z_phone;
	}
	public void setZ_phone(String z_phone) {
		this.z_phone = z_phone;
	}
	public double getDindanzojia() {
		return dindanzojia;
	}
	public void setDindanzojia(double dindanzojia) {
		this.dindanzojia = dindanzojia;
	}
	public double getZ_price() {
		return z_price;
	}
	public void setZ_price(double z_price) {
		this.z_price = z_price;
	}
	public String getTup() {
		return tup;
	}
	public void setTup(String tup) {
		this.tup = tup;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNc() {
		return nc;
	}
	public void setNc(String nc) {
		this.nc = nc;
	}
	public int getZ_iid() {
		return z_iid;
	}
	public void setZ_iid(int z_iid) {
		this.z_iid = z_iid;
	}
	public String getC_mname() {
		return c_mname;
	}
	public void setC_mname(String c_mname) {
		this.c_mname = c_mname;
	}
	public double getC_rsprice() {
		return c_rsprice;
	}
	public void setC_rsprice(double c_rsprice) {
		this.c_rsprice = c_rsprice;
	}
	public int getZ_number() {
		return z_number;
	}
	public void setZ_number(int z_number) {
		this.z_number = z_number;
	}
	public String getZ_status() {
		return z_status;
	}
	public void setZ_status(String z_status) {
		this.z_status = z_status;
	}
	
}
