package com.myself.controller.system;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myself.annotation.CtrlRequestMapping;
import com.myself.annotation.PostMapping;
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
	protected AbstractService<PrivilegeEntity, Long> getService() {
		return privilegeService;
	}

	@Override
	@PostMapping(value = "inserts" + SUFFIX)
	public String inserts(PrivilegeEntity entity) {
		List<PrivilegeEntity> list = entity.getPrivilegeList();
		return modifies(list, (l) -> getService().inserts(l));
	}

	@Override
	@PostMapping(value = "updates" + SUFFIX)
	public String updates(PrivilegeEntity entity) {
		return modifies(entity.getPrivilegeList(), (l) -> getService().updates(l));
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

}
