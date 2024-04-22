package com.zktr.entity;

import java.sql.Timestamp;

public class Zcomment {
	private int z_cid;
	private String txt;
	private Timestamp z_time;
	private int evaluation;
	private int uid;
	private int did;
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
