package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zktr.entity.ShangPin;

public class ShangPinDAO extends BaseDAO{
	public List<ShangPin> selectAll(){
		String sql="select * from c_details";
		return query(sql,new Mapper<ShangPin>() {
			@Override
			public List<ShangPin> map(ResultSet rs) throws SQLException {
				List<ShangPin>list=new ArrayList<ShangPin>();
				while(rs.next()) {
					ShangPin ss=new ShangPin(rs.getInt("c_did"),
							rs.getInt("c_mid"),
							rs.getInt("c_cid"),
							rs.getDate("c_dtime"),
							rs.getString("c_describe"),
							rs.getInt("c_dstate"));
					list.add(ss);
				}
				return list;
			}
		});
	}
	public List<ShangPin> select(Date c_dtime,int c_dstate){
		String sql="select * from c_details where c_dtime=? and c_dstate=?";
		return query(sql,new Mapper<ShangPin>() {
			@Override
			public List<ShangPin> map(ResultSet rs) throws SQLException {
				List<ShangPin> list=new ArrayList<ShangPin>();
				while(rs.next()) {
					ShangPin ss=new ShangPin(rs.getInt("c_did"),
							rs.getInt("c_mid"),
							rs.getInt("c_cid"),
							rs.getDate("c_dtime"),
							rs.getString("c_describe"),
							rs.getInt("c_dstate"));
					list.add(ss);
				}
				return list;
			}
		},c_dtime,c_dstate);
	}
	public int xg(Date c_dtime,String c_describe,int c_dstate,int c_did) {
		String sql="update c_details set c_dtime=?,c_describe=?,c_dstate=? where c_did=?";
		return execute(sql,c_dtime,c_describe,c_dstate,c_did);
	}
	public int sc(int c_did) {
		String sql="delete from c_details where c_did=?";
		return execute(sql,c_did);
	}
	public List<ShangPin> selectid(){
		String sql="select c_mid from c_details";
		return query(sql,new Mapper<ShangPin>() {
			@Override
			public List<ShangPin> map(ResultSet rs) throws SQLException {
				List<ShangPin>list=new ArrayList<ShangPin>();
				while(rs.next()) {
					int c_mid = rs.getInt("c_mid");
					ShangPin ss = new ShangPin(c_mid);
					list.add(ss);
				}
				return list;
			}
		});
	}
}
