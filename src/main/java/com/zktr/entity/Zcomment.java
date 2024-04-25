package com.zktr.entity;

import java.sql.Timestamp;

public class Zcomment {
	private int z_cid;
	private String txt;//内容
	private Timestamp z_time;//时间
	private int evaluation;//满意度
	private int uid;
	private int did;
	private String z_uname;//用户名
	private String z_avatar;//头像
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
	public Timestamp getZ_time() {
		return z_time;
	}
	public void setZ_time(Timestamp z_time) {
		this.z_time = z_time;
	}
	
}
