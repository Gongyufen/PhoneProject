
package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zktr.entity.Ueas;


public class UeasDAO extends BaseDAO{
	public List<Ueas> select(String z_uname,String z_pass) {
		String sql="select * from z_ueas where z_uname=? and z_pass=?";
		return query(sql,new Mapper<Ueas>(){
			@Override
			public List<Ueas> map(ResultSet rs) throws SQLException {
				List<Ueas> list=new ArrayList<>();
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
		return query(sql,new Mapper<Ueas>(){
			@Override
			public List<Ueas> map(ResultSet rs) throws SQLException {
				List<Ueas> list=new ArrayList<>();
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
		if(query(sql,new Mapper<Ueas>() {
			@Override
			public List<Ueas> map(ResultSet rs) throws SQLException {
				List<Ueas> list=new ArrayList<>();
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
	//修改密码
	public int xgPas(String pas,String laopas,int id) {
		String sql="update z_ueas set z_pass=? where z_uid=? and z_pass=?";
		return execute(sql,pas,id,laopas);
	}
	//修改电话
	public int xgPhone(String phone,int id) {
		String sql="update z_ueas set z_phone=? where z_uid=?";
		return execute(sql,phone,id);
	}
	//修改头像
	public int xgTx(String tx,int id) {
		String sql="update z_ueas set z_avatar=? where z_uid=?";
		return execute(sql,tx,id);
	}


	public List<Ueas> selectall() {
	    String sql = "select * from z_ueas";
	    return query(sql, new Mapper<Ueas>(){
	        @Override
	        public List<Ueas> map(ResultSet rs) throws SQLException {
	            List<Ueas> list = new ArrayList<>();
	            while (rs.next()) {
	                Ueas ueas = new Ueas(
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
	    });
	}
	public List<Ueas> cha(String z_uname,String z_phone,int z_state) {
		String sql="select * from z_ueas where z_uname=? and z_phone=? and z_state=? ";
		return query(sql,new Mapper<Ueas>() {
			@Override
			public List<Ueas> map(ResultSet rs) throws SQLException {
				List<Ueas>list=new ArrayList<Ueas>();
				if(rs.next()) {
					Ueas uu=new Ueas( rs.getInt("z_uid"),
	                        rs.getString("z_uname"),
	                        rs.getString("z_pass"),
	                        rs.getString("z_esx"),
	                        rs.getString("z_phone"),
	                        rs.getString("z_avatar"),
	                        rs.getInt("z_state"));
					list.add(uu);
				}
				return list;
			}
		}, z_uname,z_phone,z_state);
	}
	public int xg(String z_uname,String z_esx,String z_phone,int z_state,int z_uid) {
		String sql="update z_ueas set z_uname=? , z_esx=? , z_phone=? , z_state=? where z_uid=?";
		return execute(sql,z_uname,z_esx,z_phone,z_state,z_uid);
	}
	public int delete(int z_uid) {
		String sql="delete from z_ueas where z_uid=?";
		return execute(sql,z_uid);
	}
}
