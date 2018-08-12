package com.myself.controller.system;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myself.annotation.CtrlRequestMapping;
import com.myself.controller.TreeController;
import com.myself.persistence.entity.system.TreeEntity;
import com.myself.persistence.service.ModifyOperate;

/**
 * @author zhanghong
 *
 */
@CtrlRequestMapping("/system/menu")
public class MenuController extends TreeController {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

	@Override
	protected String modifies(List<TreeEntity> list, ModifyOperate<TreeEntity, String> cmd) {
		list.forEach(t -> {t.setType(0);});
		return super.modifies(list, cmd);
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
