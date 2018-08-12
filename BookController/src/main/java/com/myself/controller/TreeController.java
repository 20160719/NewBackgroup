package com.myself.controller;


import javax.annotation.Resource;

import com.myself.persistence.entity.system.TreeEntity;
import com.myself.persistence.service.AbstractService;
import com.myself.persistence.service.system.ITreeService;

/**
 * @author zhanghong
 *
 */
public abstract class TreeController extends AbstractSystemController<TreeEntity, Long> {
	
	@Resource(name = "treeServiceImpl")
	private ITreeService treeService;
	
	@Override
	protected AbstractService<TreeEntity, Long> getService() {
		return treeService;
	}

	@Override
	protected Long getId(TreeEntity entity) {
		return entity.getId();
	}

}
