package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zktr.entity.Cclass;
import com.zktr.entity.Product;

/**
* @Description: 
* @author: ccy
* @date 2024年4月8日 下午7:02:13
*/

public class ProductDAO extends BaseDAO{
	//首页：查询全部商品信息
	public List<Product> xinxi(Integer cid){
		String sql = "SELECT c_model.c_mid, c_details.c_did, c_getails.c_groute, c_model.c_mname, c_details.c_describe, c_rprice.c_rsprice\r\n"
				+ "FROM c_getails\r\n"
				+ "JOIN c_details ON c_getails.c_gid = c_details.c_did\r\n"
				+ "JOIN c_model ON c_details.c_mid = c_model.c_mid\r\n"
				+ "JOIN c_rprice ON c_details.c_did = c_rprice.c_rid where c_model.c_cid = ?";
		return this.query(sql, new Mapper<Product>() {
			@Override
			public List<Product> map(ResultSet rs) throws SQLException  {
				List<Product> list = new ArrayList<>();
				while(rs.next()) {
					Product product = new Product(rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6));
					product.setC_mid(rs.getInt("c_model.c_mid"));
					list.add(product);
				}
				return list;
			}
		},cid);
	}
	
	//搜索结果：根据类别名查询商品信息
		public List<Product> leibieming(String category){
			String sql = "SELECT c_getails.c_groute, c_model.c_mname, c_details.c_describe, c_rprice.c_rsprice\r\n"
					+ "FROM c_getails\r\n"
					+ "JOIN c_details ON c_getails.c_gid = c_details.c_did\r\n"
					+ "JOIN c_model ON c_details.c_mid = c_model.c_mid\r\n"
					+ "JOIN c_rprice ON c_details.c_did = c_rprice.c_rid "
					+ "join c_class on c_class.c_cid=c_model.c_cid "
					+ "where c_class.c_category = ?";
			return this.query(sql, new Mapper<Product>() {
				@Override
				public List<Product> map(ResultSet rs) throws SQLException  {
					List<Product> list = new ArrayList<>();
					while(rs.next()) {
						Product product = new Product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
						list.add(product);
					}
					return list;
				}
			},category);
		}
		
		//商品详情：根据商品详情id查询商品信息
			public List<Product> xiangqing(int c_mid){
				String sql = "SELECT c_details.c_did, c_getails.c_groute, c_model.c_mname, c_details.c_describe, c_rprice.c_rsprice,c_rprice.c_rid\r\n"
						+ "FROM c_getails\r\n"
						+ "JOIN c_details ON c_getails.c_gid = c_details.c_did\r\n"
						+ "JOIN c_model ON c_details.c_mid = c_model.c_mid\r\n"
						+ "JOIN c_rprice ON c_details.c_did = c_rprice.c_rid where c_model.c_mid = ?";
				return this.query(sql, new Mapper<Product>() {
					@Override
					public List<Product> map(ResultSet rs) throws SQLException  {
						List<Product> list = new ArrayList<>();
						while(rs.next()) {
							Product product = new Product(rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
							product.setC_rid(rs.getInt(6));
							list.add(product);
						}
						return list;
					}
				},c_mid);
			}
			
			//商品规格：根据商品详情id查询商品信息
			public List<List<Product>> xqguige(int c_mid){
				String sql = "select * from c_sperci\r\n"
						+ "join c_details on c_sperci.`c_did`=c_details.c_did\r\n"
						+ "join c_model on c_model.`c_mid`=c_details.`c_mid`\r\n"
						+ "where c_details.`c_mid`=?";
				return query(sql, new Mapper<List<Product>>() {
					@Override
					public List<List<Product>> map(ResultSet rs) throws SQLException {
						List<List<Product>> list=new ArrayList<>();
						while(rs.next()) {
							list.add(guigexq(rs.getInt(1)));
						}
						return list;
					}
				}, c_mid);
			}
		public List<Product> guigexq(int c_aid){
			String sql="SELECT * FROM c_getails\r\n"
					+ "JOIN c_sperci ON c_sperci.`c_aid`=c_getails.`c_aid`\r\n"
					+ "JOIN c_details ON c_details.`c_did`=c_sperci.`c_did`\r\n"
					+ "JOIN c_model ON c_model.`c_mid`=c_details.`c_mid`\r\n"
					+ "WHERE c_sperci.`c_aid`=?";
			return this.query(sql,new Mapper<Product>() {
				@Override
				public List<Product> map(ResultSet rs) throws SQLException {
					List<Product> list = new ArrayList<>();
					while(rs.next()) {
						Product product = new Product();
						product.setC_aname(rs.getString(6));
						product.setC_gtails(rs.getString(3));
						product.setC_gid(rs.getInt(1));
						list.add(product);
					}
					return list;
				}
			},c_aid);
		}
}
