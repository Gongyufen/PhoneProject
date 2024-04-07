package com.zktr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 父类DAO
 * @author LiZanhong
 *
 */
public class BaseDAO {
	/**
	 * 获取连接对象
	 * @return
	 */
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp项目?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 释放资源 
	 */
	public void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 释放资源 
	 * @param stmt
	 * @param conn
	 */
	public void close(Statement stmt, Connection conn) {
		this.close(null, stmt, conn);
	}
	
	/**
	 * 绑定参数
	 * @param stmt
	 * @param params  1,2,3
	 */
	public void bindParameters(PreparedStatement stmt, Object...params) {
		if(params != null) {
			for(int i = 0; i < params.length; i ++) {
				try {
					stmt.setObject(i + 1, params[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 执行insert、update和delete语句
	 * @param sql
	 * @param params
	 * @return
	 */
	public int execute(String sql, Object...params) {
		try {
			//获取连接对象
			Connection conn = this.getConnection();
			//创建语句对象
			PreparedStatement stmt = conn.prepareStatement(sql);
			//绑定参数
			this.bindParameters(stmt, params);
			//执行SQL语句
			int v = stmt.executeUpdate();
			//释放资源 
			this.close(stmt, conn);
			//返回影响的行数 
			return v;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 执行select语句，返回List集合
	 * @param <E>
	 * @param sql
	 * @param mapper
	 * @param params
	 * @return
	 */
	public <E> List<E> query(String sql, Mapper<E> mapper, 
			Object...params){
		try {
			//获取连接对象
			Connection conn = this.getConnection();
			//创建语句对象
			PreparedStatement stmt = conn.prepareStatement(sql);
			//绑定参数
			this.bindParameters(stmt, params);
			//执行SQL语句
			ResultSet rs = stmt.executeQuery();
			//将ResultSet转换成List
			List<E> list = mapper.map(rs);
			//释放资源 
			this.close(rs, stmt, conn);
			//返回影响的行数 
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}







