package com.myself.controller.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myself.annotation.CtrlRequestMapping;
import com.myself.controller.TreeController;

/**
 * @author zhanghong
 *
 */
@CtrlRequestMapping("/system/menu")
public class MenuController extends TreeController {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

	@Override
	protected Integer getType() {
		return 0;
	}

	@Override
	protected StringBuilder getDirectory() {
		return super.getDirectory().append("menu/");
	}
	
	@Override
	protected Logger getLogger() {
		return logger;
	}

}
