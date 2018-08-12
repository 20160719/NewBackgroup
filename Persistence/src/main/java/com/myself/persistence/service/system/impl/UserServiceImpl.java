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
	protected List<UserEntity> queryByEntityIds(List<UserEntity> list) throws Exception {
		List<Long> ids = list.stream().map(u -> u.getId()).collect(Collectors.toList());
		return getMapper().queryByIds(ids);
	}

	@Override
	protected boolean compare(UserEntity entity, UserEntity oldEntity) {
		return entity.toString().equals(oldEntity.toString());
	}
	
	@Override
	protected Map<String, String> getVerifyMap() {
		return verifyMap;
	}

	public AbstractMapper<UserEntity, Long> getMapper() {
		return userMapper;
	}

}
