package com.myself.persistence.service.system.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myself.persistence.entity.system.PrivilegeEntity;
import com.myself.persistence.mapper.AbstractMapper;
import com.myself.persistence.mapper.system.PrivilegeMapper;
import com.myself.persistence.service.AbstractServiceImpl;
import com.myself.persistence.service.system.IPrivilegeService;

/**
 * @author zhanghong
 *
 */
@Service("privilegeServiceImpl")
public class PrivilegeServiceImpl extends AbstractServiceImpl<PrivilegeEntity, Long> implements IPrivilegeService {

	@Resource(name = "privilegeMapper")
	private PrivilegeMapper privilegeMapper;

	@Override
	protected AbstractMapper<PrivilegeEntity, Long> getMapper() {
		return privilegeMapper;
	}
	
}
