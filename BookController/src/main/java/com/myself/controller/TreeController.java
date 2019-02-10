package com.myself.controller;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.myself.persistence.entity.system.TreeEntity;
import com.myself.persistence.service.AbstractService;
import com.myself.persistence.service.ModifyOperate;
import com.myself.persistence.service.system.ITreeService;

/**
 * @author zhanghong
 *
 */
public abstract class TreeController extends AbstractSystemController<TreeEntity, Long> {
	
	@Resource(name = "treeServiceImpl")
	private ITreeService treeService;
	
	@Override
	public String queries(TreeEntity entity) {
		entity.setType(getType());
		return super.queries(entity);
	}

	@Override
	protected String modifies(List<TreeEntity> list, ModifyOperate<TreeEntity, String> cmd) {
		list.forEach((tree) -> tree.setType(getType()));
		return super.modifies(list, cmd);
	}

	@Override
	protected AbstractService<TreeEntity, Long> getService() {
		return treeService;
	}

	@Override
	protected void setCreateTime(TreeEntity entity) {
		entity.setCreateTime(new Date());
	}

	@Override
	protected void setUpdateTime(TreeEntity entity) {
		entity.setUpdateTime(new Date());
	}
	
	protected Integer getType() {
		return null;
	}

//	@Override
//	protected Long getId(TreeEntity entity) {
//		return entity.getId();
//	}

}
