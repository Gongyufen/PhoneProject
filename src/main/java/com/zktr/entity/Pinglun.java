package com.zktr.entity;

import java.sql.Timestamp;

public class Pinglun{
	private int z_cid;
	private String z_content;
	private Timestamp z_time;
	private int z_evaluation;
	private int z_uid;
	private int c_did;
	public int getZ_cid() {
		return z_cid;
	}
	public void setZ_cid(int z_cid) {
		this.z_cid = z_cid;
	}
	public String getZ_content() {
		return z_content;
	}
	public void setZ_content(String z_content) {
		this.z_content = z_content;
	}
	public Timestamp getZ_time() {
		return z_time;
	}
	public void setZ_time(Timestamp z_time) {
		this.z_time = z_time;
	}
	public int getZ_evaluation() {
		return z_evaluation;
	}
	public void setZ_evaluation(int z_evaluation) {
		this.z_evaluation = z_evaluation;
	}
	public int getZ_uid() {
		return z_uid;
	}
	public void setZ_uid(int z_uid) {
		this.z_uid = z_uid;
	}
	public int getC_did() {
		return c_did;
	}
	public void setC_did(int c_did) {
		this.c_did = c_did;
	}
	public Pinglun(int z_cid, String z_content, Timestamp z_time, int z_evaluation, int z_uid, int c_did) {
		super();
		this.z_cid = z_cid;
		this.z_content = z_content;
		this.z_time = z_time;
		this.z_evaluation = z_evaluation;
		this.z_uid = z_uid;
		this.c_did = c_did;
	}
	public Pinglun() {
		super();
	}
	public Pinglun(int z_cid) {
		super();
		this.z_cid = z_cid;
	}
}
