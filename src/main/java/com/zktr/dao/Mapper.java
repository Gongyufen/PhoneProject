package com.zktr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author LiZanhong
 *
 * @param <E>
 */
public interface Mapper<E> {
	public List<E> map(ResultSet rs)throws SQLException;
}
