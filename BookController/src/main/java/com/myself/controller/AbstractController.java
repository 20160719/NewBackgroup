package com.myself.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.alibaba.fastjson.JSON;
import com.myself.annotation.PostMapping;
import com.myself.persistence.service.AbstractService;
import com.myself.persistence.service.ModifyOperate;

/**
 * @author zhanghong
 *
 */
public abstract class AbstractController<E, K> {
	
	@Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;
    
    protected static final String INDEX = "index";
    
    protected static final String SUFFIX = ".action";
	
	@GetMapping(value = INDEX + SUFFIX)
	public String index(){
		initIndex();
		return getDirectory().append(INDEX).toString();
	}
	
	protected void initIndex() {
		// TODO 自动生成的方法存根
	}
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder){
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		sdf.setLenient(false);
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
//	}
	
	@PostMapping(value = "inserts" + SUFFIX)
	public String inserts(@ModelAttribute("entity") E entity) {
		setCreateTime(entity);
		return modifies(entity, (l) -> getService().inserts(l));
	}
	
	@PostMapping(value = "updates" + SUFFIX)
	public String updates(@ModelAttribute("entity") E entity) {
		setUpdateTime(entity);
		return modifies(entity, (l) -> getService().updates(l));
	}
	
	@PostMapping(value = "deletes" + SUFFIX)
	public String deletes(@ModelAttribute("entity") E entity) {
		return deletes(entity, (l) -> getService().deletes(l));
	}
	
	@PostMapping(value = "queries" + SUFFIX)
	public String queries(@ModelAttribute("entity") E entity) {
		List<E> list = getService().queries(entity);
		Map<String, Object> map = null;
		int code = 0;
		if(null != list) {
			map = new HashMap<String, Object>(4);
			map.put("count", list.size());
			map.put("data", list);
		} else {
			map = new HashMap<String, Object>(2);
			code = -1;
		}
		map.put("code", code);
		map.put("msg", "");
		String result = JSON.toJSONString(map);
		return result;
	}
	
	protected void setCreateTime(E entity) {
		// TODO 自动生成的方法存根
	}
	
	protected void setUpdateTime(E entity) {
		// TODO 自动生成的方法存根
	}

//	protected K getId(E entity) {
//		return null;
//	}

	protected String modifies(E entity, ModifyOperate<E, String> cmd) {
		try {
			List<E> list = getList(1);
			list.add(entity);
			return modifies(list, cmd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected String modifies(List<E> list, ModifyOperate<E, String> cmd) {
		try {
			return cmd.operate(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected String deletes(E entity, ModifyOperate<E, String> cmd) {
		try {
			List<E> list = getList(1);
			list.add(entity);
			return cmd.operate(list);
		} catch (Exception e) {
		}
		return null;
	}
	
	protected String deletes(List<E> list, ModifyOperate<E, String> cmd) {
		try {
			return cmd.operate(list);
		} catch (Exception e) {
		}
		return null;
	}
	
	protected static <T> List<T> getList(int size) {
		return new ArrayList<T>(size);
	}
	
	protected static String getQueryStr(int size, Object data, int dataSize) {
		Map<String, Object> map = new HashMap<String, Object>(size);
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", dataSize);
		map.put("data", data);
		return JSON.toJSONString(map);
	}
	
	protected StringBuilder getDirectory() {
		// TODO 自动生成的方法存根
		return null;
	}

	protected AbstractService<E, K> getService() {
		return null;
	}
	
	protected Logger getLogger() {
		return null;
	}
	
}
