package com.zktr.dao;

public class XinghaoDAO extends BaseDAO{
	public int cr(int c_mid,int c_cid,String c_mname) {
		String sql="insert into c_model  values(?,?,?)";
		return execute(sql,c_mid,c_cid,c_mname);
	}
}
