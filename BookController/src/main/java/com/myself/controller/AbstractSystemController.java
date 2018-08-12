package com.myself.controller;

/**
 * @author zhanghong
 *
 */
public abstract class AbstractSystemController<E, K> extends AbstractController<E, K> {

	@Override
	protected StringBuilder getDirectory() {
		return new StringBuilder("system/");
	}

}
