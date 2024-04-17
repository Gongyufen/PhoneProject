package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zktr.entity.Ueas;

public class UeasDAO extends BaseDAO{
	public List<Ueas> selectall() {
	    String sql = "select * from z_ueas";
	    return query(sql, new Mapper() {
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
	                        rs.getInt("z_state"),
	                        rs.getString("c_mname")
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
	                        rs.getInt("z_state"),
	                        rs.getString("c_mname"));
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
