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
	
	//商品详情中的评论:查询显示在商品详情中的评论信息及满意度
		public List<Zcomment> selectmid(int mid){
			String sql="\r\n"
					+ "SELECT * FROM z_comment\r\n"
					+ "JOIN z_indent_details ON z_indent_details.`z_did`=z_comment.`z_did`\r\n"
					+ "JOIN z_indent ON z_indent.`z_iid`=z_indent_details.`z_iid`\r\n"
					+ "JOIN z_ueas ON z_ueas.`z_uid`=z_indent.`z_uid`\r\n"
					+ "WHERE z_indent_details.`c_mid`=?";
			return query(sql,new Mapper<Zcomment>() {
				@Override
				public List<Zcomment> map(ResultSet rs) throws SQLException {
					List<Zcomment> list=new ArrayList();
					while(rs.next()) {
						Zcomment zcomment=new Zcomment(rs.getString(5),rs.getTimestamp(4),rs.getInt(3),rs.getString(2),rs.getString(1));
						list.add(zcomment);
					}
					return list;
				}
			},mid);
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
