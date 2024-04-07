package com.zktr.entity;

public class Ueas {
	private int z_uid;
	private String z_uname;
	private String z_pass;
	private String z_esx;
	private String z_phone;
	private String z_avatar;
	private int z_state;
	public Ueas(int z_uid, String z_uname, String z_pass, String z_esx, String z_phone, String z_avatar,int z_state) {
		super();
		this.z_uid = z_uid;
		this.z_uname = z_uname;
		this.z_pass = z_pass;
		this.z_esx = z_esx;
		this.z_phone = z_phone;
		this.z_avatar = z_avatar;
		this.z_state = z_state;
	}
	public int getZ_uid() {
		return z_uid;
	}
	public void setZ_uid(int z_uid) {
		this.z_uid = z_uid;
	}
	public String getZ_uname() {
		return z_uname;
	}
	public void setZ_uname(String z_uname) {
		this.z_uname = z_uname;
	}
	public String getZ_pass() {
		return z_pass;
	}
	public void setZ_pass(String z_pass) {
		this.z_pass = z_pass;
	}
	public String getZ_esx() {
		return z_esx;
	}
	public void setZ_esx(String z_esx) {
		this.z_esx = z_esx;
	}
	public String getZ_phone() {
		return z_phone;
	}
	public void setZ_phone(String z_phone) {
		this.z_phone = z_phone;
	}
	public String getZ_avatar() {
		return z_avatar;
	}
	public void setZ_avatar(String z_avatar) {
		this.z_avatar = z_avatar;
	}
	public int getZ_state() {
		return z_state;
	}
	public void setZ_state(int z_state) {
		this.z_state = z_state;
	}
	
}
