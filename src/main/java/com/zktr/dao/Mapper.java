package com.zktr.dao;

import java.sql.ResultSet;
import java.util.List;

/**
 * ��ResultSetת����List�Ľӿ�
 * @author LiZanhong
 *
 * @param <E>
 */
public interface Mapper<E> {
	public List<E> map(ResultSet rs);
}
