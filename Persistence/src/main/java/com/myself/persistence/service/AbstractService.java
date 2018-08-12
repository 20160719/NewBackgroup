package com.myself.persistence.service;

import java.util.List;

/**
 * @author zhanghong
 *
 */
public interface AbstractService<E, K> {

	public String inserts(List<E> list);

	public String updates(List<E> list);

	public String deletes(List<K> list);

	public E query(E entity);

	public List<E> queries(E entity);

}
