package com.myself.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhanghong
 *
 */
@Mapper
public interface AbstractMapper<E, K> {

	public int inserts(@Param("list") List<E> list) throws Exception;

	public int updates(@Param("list") List<E> list) throws Exception;

	public int deletes(@Param("list") List<K> list) throws Exception;

	public E query(@Param("entity") E entity) throws Exception;

	public List<E> queries(@Param("entity") E entity) throws Exception;

	public List<E> queryByIds(@Param("list") List<K> list) throws Exception;

	public List<Integer> queryForVerify(@Param("entity") E entity) throws Exception;

}
