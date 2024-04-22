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
	public List<Gouwuche> chaxun(Integer cid ,int ysid,int ncid){
		String sql = "select * from c_model\r\n"
				+ "join c_details on c_details.`c_mid`=c_model.`c_mid`\r\n"
				+ "join c_sperci on c_sperci.`c_did`=c_details.`c_did`\r\n"
				+ "join c_getails on c_getails.`c_aid`=c_sperci.`c_aid`\r\n"
				+ "join c_fombination on c_fombination.`c_gid`=c_getails.`c_gid`\r\n"
				+ "join c_rprice on c_rprice.`c_rid`=c_fombination.`c_rid`\r\n"
				+ "where c_model.`c_mid`=? and c_fombination.c_gid IN (?,?)";
		return this.query(sql, new Mapper<Gouwuche>() {
			@Override
			public List<Gouwuche> map(ResultSet rs) throws SQLException  {
				List<Gouwuche> list = new ArrayList<>();
				if(rs.next()) {
					Gouwuche gouwuche = new Gouwuche(rs.getInt(1),rs.getString(2),rs.getString(3));
					gouwuche.setC_rid(rs.getInt(20));
					rs.next();
					
					gouwuche.setC_ysgtails(rs.getString(15));
					
					list.add(gouwuche);
					
					if(rs.next()) {
						gouwuche.setC_ncgtails(rs.getString(15));
						gouwuche.setC_rsprice(rs.getDouble(21));
					}
					
				}
				return list;
			}
		},cid,ysid,ncid);
	}
	//购物车：新增数据
	public int gouwuchexinzeng(int c_did,int c_mid,int c_rid,int z_uid) {
		String sql = "INSERT INTO c_shopping VALUES(null,?,?,?,?)";
		return this.execute(sql, c_did, c_mid,c_rid,z_uid);
	}
}
