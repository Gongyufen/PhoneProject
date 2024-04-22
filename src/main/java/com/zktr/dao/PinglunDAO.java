package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.zktr.entity.Pinglun;

public class PinglunDAO extends BaseDAO{
	public List<Pinglun> selectAll(){
		String sql="select * from z_comment";
		return query(sql,new Mapper<Pinglun>() {
			@Override
			public List<Pinglun> map(ResultSet rs) throws SQLException {
				List<Pinglun> list=new ArrayList<Pinglun>();
				while(rs.next()) {
					Pinglun pp=new Pinglun(rs.getInt("z_cid"),
							rs.getString("z_content"),
							rs.getTimestamp("z_time"),
							rs.getInt("z_evaluation"),
							rs.getInt("z_uid"),
							rs.getInt("c_did"));
					list.add(pp);
				}
				return list;
			}
		});
	}
	public List<Pinglun> select(Timestamp z_time,int z_evaluation){
		String sql="select * from z_comment where z_time=? and z_evaluation=?";
		return query(sql,new Mapper<Pinglun>() {
			@Override
			public List<Pinglun> map(ResultSet rs) throws SQLException {
				List<Pinglun> list=new ArrayList<Pinglun>();
				while(rs.next()) {
					Pinglun pp=new Pinglun(rs.getInt("z_cid"),
							rs.getString("z_content"),
							rs.getTimestamp("z_time"),
							rs.getInt("z_evaluation"),
							rs.getInt("z_uid"),
							rs.getInt("c_did"));
					list.add(pp);
				}
				return list;
			}
		},z_time,z_evaluation);
	}
	public int sc(int z_cid) {
		String sql="delete from z_comment where z_cid=?";
		return execute(sql,z_cid);
	}
}
