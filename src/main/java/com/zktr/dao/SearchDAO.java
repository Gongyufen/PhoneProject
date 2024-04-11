package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zktr.entity.Product;

/**
* @Description: 
* @author: ccy
* @date 2024年4月11日 上午11:33:11
*/

public class SearchDAO extends BaseDAO{
	//查询商品信息
		public List<Product> xinxi(){
			String sql = "SELECT c_getails.c_groute, c_model.c_mname, c_details.c_describe, c_rprice.c_rsprice\r\n"
					+ "FROM c_getails\r\n"
					+ "JOIN c_details ON c_getails.c_gid = c_details.c_did\r\n"
					+ "JOIN c_model ON c_details.c_mid = c_model.c_mid\r\n"
					+ "JOIN c_rprice ON c_details.c_did = c_rprice.c_rid;";
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
			});
		}
}
