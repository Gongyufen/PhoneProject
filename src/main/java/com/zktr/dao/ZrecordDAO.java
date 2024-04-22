package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zktr.entity.Product;

public class ZrecordDAO extends BaseDAO{
	//新增浏览记录
	public int insert(int uid,int mid) {
		String sql="insert into z_record value(null,?,?,now())";
		return execute(sql,uid,mid);
	}
	//根据用户id查询浏览记录
	public List<List<Product>> select(int uid){
		String sql="select c_mid from z_record where z_uid=?  ORDER BY z_rdate DESC";
		return (List<List<Product>>) query(sql,new Mapper<List<Product>>() {
			@Override
			public List<List<Product>> map(ResultSet rs) throws SQLException {
				List<List<Product>> list=new ArrayList<>();
				ProductDAO productDAO=new ProductDAO();
				while(rs.next()) {
					list.add(productDAO.xiangqing(rs.getInt(1)));
				}
				return list;
			}
		},uid);
	}
	
}
