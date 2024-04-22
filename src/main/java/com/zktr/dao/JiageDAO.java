package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zktr.entity.Jiage;
import com.zktr.entity.Product;

/**
* @Description: 
* @author: ccy
* @date 2024年4月18日 下午2:23:58
*/

public class JiageDAO extends BaseDAO{
	
	public List<Jiage> guige(Integer ysid,Integer ncid){
		String sql = "SELECT DISTINCT c_rprice.c_rid, c_rprice.`c_rsprice`\r\n"
				+ "FROM c_rprice \r\n"
				+ "JOIN c_fombination ON c_rprice.c_rid = c_fombination.`c_rid`\r\n"
				+ "WHERE c_fombination.c_gid IN (?,?)\r\n"
				+ "GROUP BY c_rprice.c_rid, c_rprice.`c_rsprice`\r\n"
				+ "HAVING COUNT(DISTINCT c_fombination.c_gid) = 2";
		return this.query(sql, new Mapper<Jiage>() {
			@Override
			public List<Jiage> map(ResultSet rs) throws SQLException  {
				List<Jiage> list = new ArrayList<>();
				while(rs.next()) {
					Jiage jiage=new Jiage(rs.getInt(1),rs.getDouble(2));
					list.add(jiage);
				}
				return list;
			}
		},ysid,ncid);
	}
	public List<Jiage> jiaGe(int rid){
		String sql="select * from c_rprice where c_rid=?";
		return this.query(sql, new Mapper<Jiage>() {
			@Override
			public List<Jiage> map(ResultSet rs) throws SQLException  {
				List<Jiage> list = new ArrayList<>();
				while(rs.next()) {
					Jiage jiage=new Jiage(rs.getInt(1),rs.getDouble(2));
					list.add(jiage);
				}
				return list;
			}
		},rid);
	}
}
