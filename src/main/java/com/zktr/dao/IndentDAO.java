package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zktr.entity.Indent;

public class IndentDAO extends BaseDAO{
	//查询对应用户的订单
	public List<List<Indent>> selectdd(int uid ,int ks,int tiao){
		String sql="select * from z_indent where z_uid=? LIMIT ?,?";
		return query(sql,new Mapper<List<Indent>>() {
		@Override
		public List<List<Indent>> map(ResultSet rs) throws SQLException {
			List<List<Indent>> list=new ArrayList<>();
			while(rs.next()) {
				list.add(selectxq(rs.getInt(1)));
			}
			return list;
		}},uid ,ks,tiao);
	}
	public List<Integer> totel(int uid,String zt){
		String sql="select COUNT(*) from z_indent where z_uid=? and z_status=?";
		return query(sql,new Mapper<Integer>() {
			@Override
			public List<Integer> map(ResultSet rs) throws SQLException {
				List<Integer> list=new ArrayList();
				if(rs.next()) {
					list.add(rs.getInt(1));
				}
				return list;
			}
		},uid,zt);
	}
	public List<Integer> totel(int uid){
		String sql="select COUNT(*) from z_indent where z_uid=? ";
		return query(sql,new Mapper<Integer>() {
			@Override
			public List<Integer> map(ResultSet rs) throws SQLException {
				List<Integer> list=new ArrayList();
				if(rs.next()) {
					list.add(rs.getInt(1));
				}
				return list;
			}
		},uid);
	}
	public List<List<Indent>> selectddxq(int iid){
		String sql="select * from z_indent where z_iid=?";
		return query(sql,new Mapper<List<Indent>>() {
		@Override
		public List<List<Indent>> map(ResultSet rs) throws SQLException {
			List<List<Indent>> list=new ArrayList<>();
			while(rs.next()) {
				list.add(selectxq(rs.getInt(1)));
			}
			return list;
		}},iid);
	}
	//根据订单状态查询
	public List<List<Indent>> selectdd(int uid,String z_status,int ks,int tiao){
		String sql="select * from z_indent where z_uid=? and z_status=? LIMIT ?,?";
		return query(sql,new Mapper<List<Indent>>() {
		@Override
		public List<List<Indent>> map(ResultSet rs) throws SQLException {
			List<List<Indent>> list=new ArrayList<>();
			while(rs.next()) {
				list.add(selectxq(rs.getInt(1)));
			}
			return list;
		}},uid,z_status,ks,tiao);
	}
	public List<Indent> selectxq(int id){
		String sql="SELECT * FROM z_indent_details "
				+ "JOIN z_indent ON z_indent_details.z_iid=z_indent.z_iid "
				+ "JOIN c_fombination ON c_fombination.c_rid=z_indent_details.c_rid "
				+ "JOIN c_rprice ON c_rprice.c_rid=z_indent_details.c_rid "
				+ "JOIN c_getails ON c_getails.c_gid=c_fombination.c_gid "
				+ "JOIN c_model ON z_indent_details.c_mid=c_model.c_mid "
				+ "WHERE z_indent.z_iid=?";
		return query(sql,new Mapper<Indent>() {
		@Override
		public List<Indent> map(ResultSet rs) throws SQLException {
			List<Indent> list=new ArrayList<>();
			while(rs.next()) {
				Indent indent=new Indent(rs.getInt("z_indent_details.z_iid"),
										rs.getString("c_mname"),
										rs.getDouble("c_rprice.c_rsprice"),
										rs.getInt("z_number"),
										rs.getString("z_status"),
										rs.getDouble("z_indent_details.z_price")
										);
				indent.setColor(rs.getString("c_gtails"));
				indent.setTup(rs.getString("c_groute"));
				indent.setDindanzojia(rs.getDouble("z_indent.z_price"));
				indent.setZ_consignee(rs.getString("z_consignee"));
				indent.setZ_phone(rs.getString("z_phone"));
				indent.setZ_address(rs.getString("z_address"));
				indent.setDid(rs.getInt("z_did"));
				rs.next();
				indent.setNc(rs.getString("c_gtails"));
				list.add(indent);
			}
			return list;
		}},id);
	}
	public int ddFk(int iid) {
		String sql="update z_indent set z_status='已付款' where z_iid=?";
		return execute(sql,iid);
	}
	public int ddOk(int iid) {
		String sql="update z_indent set z_status='完成交易' where z_iid=?";
		return execute(sql,iid);
	}
	//删除订单详情
	public int scDdxq(int iid) {
		String sql="delete from z_indent_details where z_iid=?;";
		return execute(sql,iid);
	}
	//删除订单
	public int scDd(int iid) {
		String sql="delete from z_indent where z_iid=?";
		return execute(sql,iid);
	}
	//修改订单地址
	public int xgDdDz(String z_consignee,String z_address,String z_phone,int iid) {
		String sql="update z_indent set z_consignee=?,z_address=?,z_phone=? where z_iid=?";
		return execute(sql,z_consignee,z_address,z_phone,iid);
	}
	//新增订单
	public int xzDd(int uid) {
		String sql="insert into z_indent value(null,?,null,null,'待付款',null,null,null)";
		return execute(sql,uid);
	}
	//确认订单
	public int okdd(double z_price,String z_consignee,String z_address,String z_phone,int uid) {
		String sql="update z_indent set z_price=?,z_date=now(),z_consignee=?,z_address=?,z_phone=? where z_iid=?";
		return execute(sql,z_price,z_consignee,z_address,z_phone,maxIid(uid).get(0));
	}
	//查询用户的最新订单
	public List<Integer> maxIid(int uid){
		String sql="select max(z_iid) from z_indent where z_uid=?";
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
	//新增订单详情
	public int insertDdXq(int uid,int rid,String category,int numder,double price,int mid) {
		String sql="insert into z_indent_details value(null,?,?,?,?,?,?)";
		return execute(sql,maxIid(uid).get(0),rid,category,numder,price,mid);
	}
	
}
