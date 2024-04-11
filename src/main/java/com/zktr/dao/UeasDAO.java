package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zktr.entity.Ueas;

public class UeasDAO extends BaseDAO{
	public List<Ueas> selectall() {
	    String sql = "select * from z_ueas";
	    return query(sql, new Mapper() {
	        @Override
	        public List<Ueas> map(ResultSet rs) throws SQLException {
	            List<Ueas> list = new ArrayList<>();
	            while (rs.next()) {
	                Ueas ueas = new Ueas(
	                        rs.getInt("z_uid"),
	                        rs.getString("z_uname"),
	                        rs.getString("z_pass"),
	                        rs.getString("z_esx"),
	                        rs.getString("z_phone"),
	                        rs.getString("z_avatar"),
	                        rs.getInt("z_state"),
	                        rs.getString("c_mname")
	                );
	                list.add(ueas);
	            }
	            return list;
	        }
	    });
	}
	public void insert(String z_uname,String z_esx,String z_phone,String z_pass) {
		String sql="insert into z_ueas values(null,?,?,?,?,null,'用户')";
		execute(sql,z_uname,z_pass,z_esx,z_phone);
	}
}
