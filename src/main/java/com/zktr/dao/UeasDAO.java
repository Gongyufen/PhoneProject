package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zktr.entity.Ueas;


public class UeasDAO extends BaseDAO{
	public List<Ueas> select(String z_uname,String z_pass) {
		String sql="select * from z_ueas where z_uname=? and z_pass=?";
		return query(sql,new Mapper(){
			@Override
			public List<Ueas> map(ResultSet rs) throws SQLException {
				List<Ueas> list=new ArrayList();
				if (rs.next()) {
					Ueas ueas=new Ueas(
							rs.getInt("z_uid"),
							rs.getString("z_uname"),
							rs.getString("z_pass"),
							rs.getString("z_esx"),
							rs.getString("z_phone"),
							rs.getString("z_avatar"),
							rs.getInt("z_state")
					);
					list.add(ueas);
				}
				if(list!=null) {
					return list;
				}else {
					return null;
				}
				
			}
		},z_uname,z_pass);
	}
	//根据id查询
	public List<Ueas> select(int id) {
		String sql="select * from z_ueas where z_uid=?";
		return query(sql,new Mapper(){
			@Override
			public List<Ueas> map(ResultSet rs) throws SQLException {
				List<Ueas> list=new ArrayList();
				if (rs.next()) {
					Ueas ueas=new Ueas(
							rs.getInt("z_uid"),
							rs.getString("z_uname"),
							rs.getString("z_pass"),
							rs.getString("z_esx"),
							rs.getString("z_phone"),
							rs.getString("z_avatar"),
							rs.getInt("z_state")
					);
					list.add(ueas);
				}
				if(list!=null) {
					return list;
				}else {
					return null;
				}
				
			}
		},id);
	}
	public void insert(String z_uname,String z_pass,String z_esx,String z_phone) {
		String sql="insert into z_ueas values(null,?,?,?,?,null,1)";
		execute(sql,z_uname,z_pass,z_esx,z_phone);
	}
	//判断
	public boolean judge(String z_uname) {
		String sql="select * from z_ueas where z_uname=?";
		if(query(sql,new Mapper() {
			@Override
			public List map(ResultSet rs) throws SQLException {
				List<Ueas> list=new ArrayList();
				if(rs.next()) {
					Ueas ueas=new Ueas(
							rs.getInt("z_uid"),
							rs.getString("z_uname"),
							rs.getString("z_pass"),
							rs.getString("z_esx"),
							rs.getString("z_phone"),
							rs.getString("z_avatar"),
							rs.getInt("z_state")
					);
					list.add(ueas);
				}
				return list;
			}
		},z_uname).size()!=0) {
			return false;
		}else {
			return true;
		}
	}
	//修改用户名
	public void xgName(String name,int id) {
		String sql="update z_ueas set z_uname=? where z_uid=?";
		execute(sql,name,id);
	}
}
