package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zktr.entity.Guigexq;

public class GuigexqDAO extends BaseDAO{
	public List<Guigexq> selectAll(){
		String sql="select * from c_getails";
		return query(sql,new Mapper<Guigexq>() {
			@Override
			public List<Guigexq> map(ResultSet rs) throws SQLException {
				List<Guigexq> list=new ArrayList<Guigexq>();
				while(rs.next()) {
					Guigexq gg=new Guigexq(rs.getInt("c_gid"),rs.getInt("c_aid"),rs.getString("c_gtails"),
							rs.getString("c_groute"));
					list.add(gg);
				}
				return list;
			}
		});
	}
	public List<Guigexq> select(String c_gtails){
		String sql="select * from c_getails where c_gtails=?";
		return query(sql,new Mapper<Guigexq>() {
			@Override
			public List<Guigexq> map(ResultSet rs) throws SQLException {
				List<Guigexq> list=new ArrayList<Guigexq>();
				while(rs.next()) {
					Guigexq gg=new Guigexq(rs.getInt("c_gid"),rs.getInt("c_aid"),rs.getString("c_gtails"),
							rs.getString("c_groute"));
					list.add(gg);
				}
				return list;
			}
		},c_gtails);
	}
	public int sc(int c_gid) {
		String sql="delete from c_getails where c_gid=?";
		return execute(sql,c_gid);
	}
}
