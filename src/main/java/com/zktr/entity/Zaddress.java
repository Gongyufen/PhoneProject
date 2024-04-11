package com.zktr.entity;

public class Zaddress {
	private int z_aid;
	private int z_uid;
	private String z_address;
	private String z_consignee;
	private String z_phone;
	private int z_state;
	public Zaddress(int z_aid, int z_uid, String z_address, String z_consignee, String z_phone, int z_state) {
		super();
		this.z_aid = z_aid;
		this.z_uid = z_uid;
		this.z_address = z_address;
		this.z_consignee = z_consignee;
		this.z_phone = z_phone;
		this.z_state = z_state;
	}
	public int getZ_aid() {
		return z_aid;
	}
	public void setZ_aid(int z_aid) {
		this.z_aid = z_aid;
	}
	public int getZ_uid() {
		return z_uid;
	}
	public void setZ_uid(int z_uid) {
		this.z_uid = z_uid;
	}
	public String getZ_address() {
		return z_address;
	}
	public void setZ_address(String z_address) {
		this.z_address = z_address;
	}
	public String getZ_consignee() {
		return z_consignee;
	}
	public void setZ_consignee(String z_consignee) {
		this.z_consignee = z_consignee;
	}
	public String getZ_phone() {
		return z_phone;
	}
	public void setZ_phone(String z_phone) {
		this.z_phone = z_phone;
	}
	public int getZ_state() {
		return z_state;
	}
	public void setZ_state(int z_state) {
		this.z_state = z_state;
	}
	
}
