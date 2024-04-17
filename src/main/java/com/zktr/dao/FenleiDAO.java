package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zktr.entity.Fenlei;

public class FenleiDAO extends BaseDAO{
	public List<Fenlei> selectAll(){
		String sql="select * from c_class";
		return query(sql,new Mapper<Fenlei>() {
			@Override
			public List<Fenlei> map(ResultSet rs) throws SQLException {
				List<Fenlei> list=new ArrayList<Fenlei>();
				while(rs.next()) {
					Fenlei ff=new Fenlei(rs.getInt("c_cid"),rs.getString("c_category"));
					list.add(ff);
				}
				return list;
			}
		});
	}
	public List<Fenlei> select(String c_category){
		String sql="select * from c_class where c_category=? ";
		return query(sql,new Mapper<Fenlei>() {
			@Override
			public List<Fenlei> map(ResultSet rs) throws SQLException {
				List<Fenlei> list=new ArrayList<Fenlei>();
				if(rs.next()) {
					Fenlei ff=new Fenlei(rs.getInt("c_cid"),rs.getString("c_category"));
					list.add(ff);
				}
				return list;
			}
		},c_category);
	}
	public int xg(String c_category,int c_cid) {
		String sql="update c_class set c_category=? where c_cid=?";
		return execute(sql,c_category,c_cid);
	}
	public 	int delete(int c_cid) {
		String sql="delete from c_class where c_cid=?";
		return execute(sql,c_cid);
	}
}
