package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zktr.entity.Cclass;
import com.zktr.entity.Model;

/**
* @Description: 
* @author: ccy
* @date 2024年4月7日 上午8:38:03
*/

public class ModelDAO extends BaseDAO{
	//查询型号
	public List<Model> query(int id){
		String sql = "select * from c_model where c_cid=?";
		return this.query(sql, new Mapper<Model>() {
			@Override
			public List<Model> map(ResultSet rs) throws SQLException  {
				List<Model> list = new ArrayList<>();
				while(rs.next()) {
					Model model = new Model(rs.getInt(1), rs.getInt(2), rs.getString(3));
					list.add(model);
				}
				return list;
			}
		},id);
	}	
}
