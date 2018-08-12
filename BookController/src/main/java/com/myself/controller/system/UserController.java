package com.myself.controller.system;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myself.annotation.CtrlRequestMapping;
import com.myself.controller.AbstractSystemController;
import com.myself.persistence.entity.system.UserEntity;
import com.myself.persistence.service.AbstractService;
import com.myself.persistence.service.system.IUserService;

/**
 * @author zhanghong
 *
 */
@CtrlRequestMapping("/system/user")
public class UserController extends AbstractSystemController<UserEntity, Long> {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource(name = "userServiceImpl")
	private IUserService userService;
	
	@Override
	public AbstractService<UserEntity, Long> getService() {
		return userService;
	}

	@Override
	protected Long getId(UserEntity entity) {
		return entity.getId();
	}

	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	protected StringBuilder getDirectory() {
		return super.getDirectory().append("user/");
	}
	
}
