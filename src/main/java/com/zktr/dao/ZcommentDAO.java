package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zktr.entity.Zcomment;

public class ZcommentDAO extends BaseDAO{
	//新增评论
	public int insert(String txt,int evaluation,int uid,int did) {
		String sql=" INSERT INTO z_comment VALUE(NULL,?,NOW(),?,?,?)";
		return execute(sql,txt,evaluation,uid,did);
	}
	//查看用户个人评论
	public List<Zcomment> selectuid(int uid){
		String sql="select * from z_comment where z_uid=?";
		return query(sql,new Mapper<Zcomment>() {
			@Override
			public List<Zcomment> map(ResultSet rs) throws SQLException {
				List<Zcomment> list=new ArrayList();
				while(rs.next()) {
					Zcomment zcomment=new Zcomment(rs.getInt(1),rs.getString(2),rs.getTimestamp(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
					list.add(zcomment);
				}
				return list;
			}
		},uid);
	}
}
