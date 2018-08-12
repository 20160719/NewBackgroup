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

	@Override
	protected List<TreeEntity> queryByEntityIds(List<TreeEntity> list) throws Exception {
		List<Long> ids = list.stream().map(t -> t.getId()).collect(Collectors.toList());
		return getMapper().queryByIds(ids);
	}

	@Override
	protected boolean compare(TreeEntity entity, TreeEntity oldEntity) {
		return entity.toString().equals(oldEntity.toString());
	}

	@Override
	protected Map<String, String> getVerifyMap() {
		return verifyMap;
	}

	public AbstractMapper<TreeEntity, Long> getMapper() {
		return treeMapper;
	}

}
