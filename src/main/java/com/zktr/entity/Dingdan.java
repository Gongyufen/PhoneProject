package com.zktr.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Dingdan {
	private int z_iid;
	private int z_uid;
	private BigDecimal z_price;
	private Timestamp z_date;
	private String z_status;
	private String z_consignee;
	private String z_address;
	private String z_phone;
	public int getZ_iid() {
		return z_iid;
	}
	public void setZ_iid(int z_iid) {
		this.z_iid = z_iid;
	}
	public int getZ_uid() {
		return z_uid;
	}
	public void setZ_uid(int z_uid) {
		this.z_uid = z_uid;
	}
	public BigDecimal getZ_price() {
		return z_price;
	}
	public void setZ_price(BigDecimal z_price) {
		this.z_price = z_price;
	}
	public Timestamp getZ_date() {
		return z_date;
	}
	public void setZ_date(Timestamp z_date) {
		this.z_date = z_date;
	}
	public String getZ_status() {
		return z_status;
	}
	public void setZ_status(String z_status) {
		this.z_status = z_status;
	}
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
	public Dingdan(int z_iid, int z_uid, BigDecimal z_price, Timestamp z_date, String z_status, String z_consignee,
			String z_address, String z_phone) {
		super();
		this.z_iid = z_iid;
		this.z_uid = z_uid;
		this.z_price = z_price;
		this.z_date = z_date;
		this.z_status = z_status;
		this.z_consignee = z_consignee;
		this.z_address = z_address;
		this.z_phone = z_phone;
	}
	public Dingdan() {
		super();
	}
	public Dingdan(int z_iid) {
		super();
		this.z_iid = z_iid;
	}
}
