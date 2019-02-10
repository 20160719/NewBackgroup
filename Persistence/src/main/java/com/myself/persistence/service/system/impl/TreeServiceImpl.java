package com.myself.persistence.service.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myself.persistence.entity.system.TreeEntity;
import com.myself.persistence.mapper.AbstractMapper;
import com.myself.persistence.mapper.system.TreeMapper;
import com.myself.persistence.service.AbstractServiceImpl;
import com.myself.persistence.service.system.ITreeService;

/**
 * @author zhanghong
 *
 */
@Service("treeServiceImpl")
public class TreeServiceImpl extends AbstractServiceImpl<TreeEntity, Long> implements ITreeService {
	
	private static Map<String, String> verifyMap = new HashMap<String, String>(1);

	static {
		verifyMap.put("0", "用户账户已存在");
	}
	
	@Resource(name = "treeMapper")
	private TreeMapper treeMapper;
	
//	@Override
//	public List<TreeEntity> queries(TreeEntity entity) {
//		List<TreeEntity> list = super.queries(entity);
//		return super.queries(entity);
//	}

	@Override
	protected List<Long> getEntityIds(List<TreeEntity> list) {
		return list.stream().map(t -> t.getId()).collect(Collectors.toList());
	}

	@Override
	protected boolean isEqual(TreeEntity entity, TreeEntity oldEntity) {
		return !entity.fieldsIsChanged(oldEntity, false);
	}
	
	@Override
	protected void setFieldNull(TreeEntity entity, TreeEntity oldEntity) {
		entity.fieldsIsChanged(oldEntity, true);
	}

	@Override
	protected Map<String, String> getVerifyMap() {
		return verifyMap;
	}

	public AbstractMapper<TreeEntity, Long> getMapper() {
		return treeMapper;
	}

}
