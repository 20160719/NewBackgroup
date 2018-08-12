package com.myself.persistence.service;

import java.util.List;

public interface DeleteOperate<K, R> {
	
	public R operate(List<K> list) throws Exception;

}
