package com.myself.controller.system;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myself.annotation.CtrlRequestMapping;
import com.myself.controller.AbstractSystemController;
import com.myself.persistence.entity.system.PrivilegeEntity;
import com.myself.persistence.service.AbstractService;
import com.myself.persistence.service.system.IPrivilegeService;

/**
 * @author zhanghong
 *
 */
@CtrlRequestMapping("/system/privilege")
public class PrivilegeController extends AbstractSystemController<PrivilegeEntity, Long> {

	private static final Logger logger = LoggerFactory.getLogger(PrivilegeController.class);
	
	@Resource(name = "privilegeServiceImpl")
	private IPrivilegeService privilegeService;
	
	@Override
	protected Long getId(PrivilegeEntity entity) {
		return entity.getId();
	}

	@Override
	protected AbstractService<PrivilegeEntity, Long> getService() {
		return privilegeService;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

}
