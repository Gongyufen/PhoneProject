package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zktr.entity.Guige;

public class GuigeDAO extends BaseDAO{
	public List<Guige> selectAll(){
		String sql="select * from c_sperci";
		return query(sql,new Mapper<Guige>() {
			@Override
			public List<Guige> map(ResultSet rs) throws SQLException {
				List<Guige>list=new ArrayList<Guige>();
				while(rs.next()) {
					Guige gg=new Guige(rs.getInt("c_aid"),rs.getString("c_aname"),rs.getInt("c_did"));
					list.add(gg);
				}
				return list;
			}
		});
	}
	public List<Guige> select(String c_aname){
		String sql="select * from c_sperci where c_aname=?";
		return query(sql,new Mapper<Guige>() {
			@Override
			public List<Guige> map(ResultSet rs) throws SQLException {
				List<Guige>list=new ArrayList<Guige>();
				while(rs.next()) {
					Guige gg=new Guige(rs.getInt("c_aid"),rs.getString("c_aname"),rs.getInt("c_did"));
					list.add(gg);
				}
				return list;
			}
		},c_aname);
	}
	public int sc(int c_aid) {
		String sql="delete from c_sperci where c_aid=?";
		return execute(sql,c_aid);
	}
}
