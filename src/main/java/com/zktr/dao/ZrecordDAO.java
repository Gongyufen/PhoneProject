package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZrecordDAO extends BaseDAO{
	public int insert(int uid,int mid) {
		String sql="insert into z_record value(null,?,?,now())";
		return execute(sql,uid,mid);
	}
	public List<Integer> select(int uid){
		String sql="select c_mid from z_record where z_uid=?";
		return query(sql,new Mapper<Integer>() {
			@Override
			public List<Integer> map(ResultSet rs) throws SQLException {
				List<Integer> list=new ArrayList<>();
				while(rs.next()) {
					list.add(rs.getInt(1));
				}
				return list;
			}
		},uid);
	}
	
}
