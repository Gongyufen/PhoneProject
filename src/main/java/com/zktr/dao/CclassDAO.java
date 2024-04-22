package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zktr.entity.Cclass;

/**
* @Description: 
* @author: ccy
* @date 2024年4月7日 上午8:37:39
*/

public class CclassDAO extends BaseDAO{
	//查询类别
	public List<Cclass> query(){
		String sql = "select * from c_class";
		return this.query(sql, new Mapper<Cclass>() {
			@Override
			public List<Cclass> map(ResultSet rs) throws SQLException  {
				List<Cclass> list = new ArrayList<>();
				while(rs.next()) {
					Cclass cclass = new Cclass(rs.getInt(1), rs.getString(2));
					list.add(cclass);
				}
				return list;
			}
		});
	}
	public List<Cclass> select(int mid){
		String sql = "select c_class.* from c_class "
				+ "join c_model on c_model.c_cid=c_class.c_cid "
				+ "where c_model.c_mid=?";
		return this.query(sql, new Mapper<Cclass>() {
			@Override
			public List<Cclass> map(ResultSet rs) throws SQLException  {
				List<Cclass> list = new ArrayList<>();
				while(rs.next()) {
					Cclass cclass = new Cclass(rs.getInt(1), rs.getString(2));
					list.add(cclass);
				}
				return list;
			}
		},mid);
	}
}
