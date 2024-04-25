package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zktr.entity.Gouwuche;
import com.zktr.entity.Product;

/**
* @Description: 
* @author: ccy
* @date 2024年4月19日 上午9:09:46
*/

public class GouwucheDAO extends BaseDAO{
	//购物车：查询图片与名称
	public List<Gouwuche> chaxun(int uid){
		String sql = "SELECT * FROM c_shopping\r\n"
				+ "JOIN c_model ON c_model.`c_mid`=c_shopping.`c_mid` "
				+ "JOIN c_details ON c_details.`c_did`=c_shopping.`c_did` "
				+ "JOIN c_getails ON c_getails.`c_gid`=c_shopping.`c_ysid` OR c_getails.`c_gid`=c_shopping.`c_ncid` "
				+ "JOIN z_ueas ON z_ueas.`z_uid`=c_shopping.`z_uid` "
				+ "JOIN c_rprice ON c_rprice.`c_rid`=c_shopping.`c_rid` "
				+ "WHERE z_ueas.`z_uid`=?";
		return this.query(sql, new Mapper<Gouwuche>() {
			@Override
			public List<Gouwuche> map(ResultSet rs) throws SQLException  {
				List<Gouwuche> list = new ArrayList<>();
				while(rs.next()) {
					Gouwuche gouwuche=new Gouwuche(rs.getString("c_groute"), rs.getString("c_mname"), rs.getString("c_gtails"),rs.getDouble("c_rsprice"),rs.getInt("c_model.c_mid"),rs.getInt(4),rs.getInt("c_ssl"));
					gouwuche.setC_sid(rs.getInt(1));
					rs.next();
					gouwuche.setC_ncgtails(rs.getString("c_gtails"));
					list.add(gouwuche);
				}
				return list;
			}
		},uid);
	}
	//删除购物车
	public int delete(int sid) {
		String sql="delete from c_shopping where c_sid=?";
		return execute(sql, sid);
	}
	//购物车：新增数据
	public int gouwuchexinzeng(int c_did,int c_mid,int c_ysid,int c_ncid,int c_rid,int z_uid,int c_ssl) {
		String sql = "INSERT INTO c_shopping VALUES(null,?,?,?,?,?,?,?)";
		return this.execute(sql, c_did, c_mid,c_rid,c_ysid,c_ncid,z_uid,c_ssl);
	}
	//购物车数量：根据加减改变小计
	public int jiajian(int c_ssl,int c_sid) {
		String  sql = "UPDATE c_shopping SET c_ssl = ? where c_sid = ?";
		return execute(sql, c_ssl, c_sid);
	}
	
}
