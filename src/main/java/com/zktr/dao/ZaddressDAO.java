package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zktr.entity.Zaddress;

public class ZaddressDAO extends BaseDAO{
	//删除
	public int delete(int id) {
		String sql="delete from z_address where z_aid=?";
		return execute(sql,id);
	}
	//新增
	public int insert(int uid,String address,String name,String phone) {
		String sql="INSERT INTO z_address VALUES(NULL,?,?,?,?,1)";
		return execute(sql,uid,address,name,phone);
	}
	//修改
	public int update(int aid,String address,String name,String phone) {
		String sql="update z_address set z_address=?,z_consignee=?,z_phone=? where z_aid=?";
		return execute(sql,address,name,phone,aid);
	}
	public List<Zaddress> select(int uid){
		String sql="select * from z_address where z_uid=?";
		return query(sql,new Mapper<Zaddress>() {
			@Override
			public List<Zaddress> map(ResultSet rs) throws SQLException {
				List<Zaddress> list=new ArrayList<>();
				while(rs.next()) {
					Zaddress zaddress=new Zaddress(
								rs.getInt(1),
								rs.getInt(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getInt(6)
							);
					if(rs.getInt(6)!=2) {
						list.add(zaddress);
					}
				}
				return list;
			}
		},uid);
	}
}
