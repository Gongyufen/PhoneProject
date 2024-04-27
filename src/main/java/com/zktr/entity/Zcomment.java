package com.zktr.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Zcomment {
	private int z_cid;
	private String txt;//内容
	private Timestamp z_time;//时间
	private int evaluation;//满意度
	private int uid;
	private int did;

	private String z_uname;//用户名
	private String z_avatar;//头像
	private int iid;
	
	
	public String getZ_uname() {
		return z_uname;
	}
	public void setZ_uname(String z_uname) {
		this.z_uname = z_uname;
	}
	public String getZ_avatar() {
		return z_avatar;
	}
	public void setZ_avatar(String z_avatar) {
		this.z_avatar = z_avatar;
	}
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public int getZ_cid() {
		return z_cid;
	}
	public void setZ_cid(int z_cid) {
		this.z_cid = z_cid;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public int getEvaluation() {
		return evaluation;
	}
	
	public Zcomment(String txt, Timestamp z_time, int evaluation, String z_uname, String z_avatar) {
		super();
		this.txt = txt;
		this.z_time = z_time;
		this.evaluation = evaluation;
		this.z_uname = z_uname;
		this.z_avatar = z_avatar;
	}
	public Zcomment(int z_cid, String txt, Timestamp z_time, int evaluation, int uid, int did) {
		super();
		this.z_cid = z_cid;
		this.txt = txt;
		this.z_time = z_time;
		this.evaluation = evaluation;
		this.uid = uid;
		this.did = did;
	}
	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getZ_time() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatted_time = sdf.format(z_time);
		return formatted_time;
	}
	public void setZ_time(Timestamp z_time) {
		this.z_time = z_time;
	}
	
}
