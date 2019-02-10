package com.myself.persistence.service.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myself.persistence.entity.system.UserEntity;
import com.myself.persistence.mapper.AbstractMapper;
import com.myself.persistence.mapper.system.UserMapper;
import com.myself.persistence.service.AbstractServiceImpl;
import com.myself.persistence.service.system.IUserService;

/**
 * @author zhanghong
 *
 */
@Service("userServiceImpl")
public class UserServiceImpl extends AbstractServiceImpl<UserEntity, Long> implements IUserService {

	private static Map<String, String> verifyMap = new HashMap<String, String>(1);

	static {
		verifyMap.put("0", "用户账户已存在");
	}

	@Resource(name = "userMapper")
	private UserMapper userMapper;

	@Override
	protected List<Long> getEntityIds(List<UserEntity> list) {
		return list.stream().map(u -> u.getId()).collect(Collectors.toList());
	}

	@Override
	protected boolean isEqual(UserEntity entity, UserEntity oldEntity) {
		return !entity.fieldsIsChanged(oldEntity, false);
	}
	
	@Override
	protected void setFieldNull(UserEntity entity, UserEntity oldEntity) {
		entity.fieldsIsChanged(oldEntity, true);
	}

	@Override
	protected Map<String, String> getVerifyMap() {
		return verifyMap;
	}

	public AbstractMapper<UserEntity, Long> getMapper() {
		return userMapper;
	}

}
