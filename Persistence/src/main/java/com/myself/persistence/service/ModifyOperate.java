/**
 * 
 */
package com.myself.persistence.service;

import java.util.List;

/**
 * @author zhanghong
 *
 */
public interface ModifyOperate<E, R> {
	
	public R operate(List<E> list) throws Exception;
	
}
