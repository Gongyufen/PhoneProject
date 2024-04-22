package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.zktr.entity.Dingdan;

public class DingdanDAO extends BaseDAO{
	public List<Dingdan> selectAll(){
		String sql="select * from z_indent";
		return query(sql,new Mapper<Dingdan>() {
			@Override
			public List<Dingdan> map(ResultSet rs) throws SQLException {
				List<Dingdan> list=new ArrayList<Dingdan>();
				while(rs.next()) {
					Dingdan dd=new Dingdan(rs.getInt("z_iid"),
							rs.getInt("z_uid"),
							rs.getBigDecimal("z_price"),
							rs.getTimestamp("z_date"),
							rs.getString("z_status"),
							rs.getString("z_consignee"),
							rs.getString("z_address"),
							rs.getString("z_phone"));
					list.add(dd);
				}
				return list;
			}
		});
	}
	public List<Dingdan> select(Timestamp z_date,String z_status){
		String sql="select * from z_indent where z_date=? and z_status=?";
		return query(sql,new Mapper<Dingdan>() {
			@Override
			public List<Dingdan> map(ResultSet rs) throws SQLException {
				List<Dingdan> list=new ArrayList<Dingdan>();
				while(rs.next()) {
					Dingdan dd=new Dingdan(rs.getInt("z_iid"),
							rs.getInt("z_uid"),
							rs.getBigDecimal("z_price"),
							rs.getTimestamp("z_date"),
							rs.getString("z_status"),
							rs.getString("z_consignee"),
							rs.getString("z_address"),
							rs.getString("z_phone"));
					list.add(dd);
				}
				return list;
			}
		}, z_date,z_status);
	}
	public int xg(Timestamp z_date,String z_status,String z_consignee,String z_address,String z_phone,int z_iid) {
		String sql="update z_indent set z_date=?,z_status=?,z_consignee=?,z_address=?,z_phone=? where z_iid=?";
		return execute(sql,z_date,z_status,z_consignee,z_address,z_phone,z_iid);
	}
	public int sc(int z_iid) {
		String sql="delete from z_indent where z_iid=? ";
		return execute(sql,z_iid);
	}
}
