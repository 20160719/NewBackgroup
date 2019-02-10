package com.myself.controller.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myself.annotation.CtrlRequestMapping;
import com.myself.controller.TreeController;

/**
 * @author zhanghong
 *
 */
@CtrlRequestMapping("/system/role")
public class RoleController extends TreeController {
	
	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Override
	protected Integer getType() {
		return 1;
	}

	@Override
	protected StringBuilder getDirectory() {
		return super.getDirectory().append("role/");
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

}
