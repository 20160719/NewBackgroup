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
import com.myself.persistence.service.DeleteOperate;
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
	
	@PostMapping(value = "inserts" + SUFFIX)
	public String inserts(@ModelAttribute("entity") E entity) {
		return modifies(entity, (l) -> getService().inserts(l));
	}
	
	@PostMapping(value = "updates" + SUFFIX)
	public String updates(@ModelAttribute("entity") E entity) {
		return modifies(entity, (l) -> getService().updates(l));
	}
	
	@PostMapping(value = "deletes" + SUFFIX)
	public String deletes(@ModelAttribute("entity") E entity) {
		return deletes(getId(entity), (l) -> getService().deletes(l));
	}
	
	@PostMapping(value = "queries" + SUFFIX)
	public String queries(@ModelAttribute("entity") E entity) {
		return getQueryStr(3, getService().queries(entity));
	}

	protected K getId(E entity) {
		return null;
	}

	protected String modifies(E entity, ModifyOperate<E, String> cmd) {
		try {
			List<E> list = getList(1);
			list.add(entity);
			return cmd.operate(list);
		} catch (Exception e) {
		}
		return null;
	}
	
	protected String modifies(List<E> list, ModifyOperate<E, String> cmd) {
		try {
			return cmd.operate(list);
		} catch (Exception e) {
		}
		return null;
	}
	
	protected String deletes(K key, DeleteOperate<K, String> cmd) {
		try {
			List<K> list = getList(1);
			list.add(key);
			return cmd.operate(list);
		} catch (Exception e) {
		}
		return null;
	}
	
	protected String deletes(List<K> list, DeleteOperate<K, String> cmd) {
		try {
			return cmd.operate(list);
		} catch (Exception e) {
		}
		return null;
	}
	
	protected static <T> List<T> getList(int size) {
		return new ArrayList<T>(size);
	}
	
	protected static String getQueryStr(int size, Object data) {
		Map<String, Object> map = new HashMap<String, Object>(size);
		map.put("code", 0);
		map.put("msg", "");
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
