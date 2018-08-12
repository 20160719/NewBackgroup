package com.myself.persistence.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;

import com.myself.constant.CommonConstant;
import com.myself.constant.CommonResult;
import com.myself.exception.ChangeException;
import com.myself.exception.VerifyException;
import com.myself.persistence.mapper.AbstractMapper;

/**
 * @author zhanghong
 *
 */
public abstract class AbstractServiceImpl<E, K> implements AbstractService<E, K> {
	
	@Override
	public String inserts(List<E> list) {
		return modifies(list, (l) -> getMapper().inserts(l), CommonConstant.OP_INSERTS);
	}

	@Override
	public String updates(List<E> list) {
		return modifies(list, (l) -> getMapper().updates(l), CommonConstant.OP_UPDATES);
	}

	@Override
	public String deletes(List<K> list) {
		return deletes(list, (l) -> getMapper().deletes(l), CommonConstant.OP_DELETES);
	}

	@Override
	public E query(E entity) {
		try {
			return getMapper().query(entity);
		} catch (Exception e) {
			getLogger().error("[query error] {}", e);
		}
		return null;
	}

	@Override
	public List<E> queries(E entity) {
		try {
			return getMapper().queries(entity);
		} catch (Exception e) {
			getLogger().error("[queries error] {}", e);
		}
		return null;
	}
	
	protected String modifies(List<E> list, ModifyOperate<E, Integer> cmd, String opType) {
		String result = CommonResult.OPERATE_FALID.toString();
		try {
			if (opType.equals(CommonConstant.OP_INSERTS)) {
				verify(list);
			} else if (opType.equals(CommonConstant.OP_UPDATES)) {
				isChanged(list);
				verify(list);
			}
			if (cmd.operate(list).intValue() > 0) {
				return CommonResult.OPERATE_SUCCESS.toString();
			}
		} catch (VerifyException e) {
			// TODO
			result = e.toString();
		} catch (ChangeException e) {
			// TODO
			result = e.toString();
		} catch (Exception e) {
			getLogger().error("[operate error] {}", e);
		}
		return result;
	}
	
	protected String deletes(List<K> list, DeleteOperate<K, Integer> cmd, String opType) {
		String result = CommonResult.OPERATE_FALID.toString();
		try {
			if (cmd.operate(list).intValue() > 0) {
				return CommonResult.OPERATE_SUCCESS.toString();
			}
		} catch (Exception e) {
			getLogger().error("[deletes error] {}", e);
		}
		return result;
	}

	private void verify(List<E> list) throws VerifyException {
		for (E entity : list) {
			verifyEntity(entity);
		}

	}

	protected void verifyEntity(E entity) throws VerifyException {
		int sum = 0;
		String msg = null;
		try {
			List<Integer> list = getMapper().queryForVerify(entity);
			List<String> errorMsg = null;
			for (int i = 0, size = list.size(); i < size; i++) {
				int r = list.get(i).intValue();
				if (1 <= r) {
					if (null == errorMsg)
						errorMsg = new ArrayList<String>(size);
					errorMsg.add(getVerifyMap().get(String.valueOf(r)));
				}
			}
			if (null != errorMsg)
				msg = Arrays.toString(errorMsg.toArray());
		} catch (Exception e) {
			getLogger().error("[queryForVerify error] {}", e);
		}
		if (sum > 0) {
			throw new VerifyException(10, msg);
		}

	}

	protected void isChanged(List<E> list) throws ChangeException {
		List<E> oldList = null;
		try {
			oldList = queryByEntityIds(list);
		} catch (Exception e) {
			getLogger().error("[queryByEntityIds error] {}", e);
			return;
		}
		for (int m = 0, size = list.size(); m < size; m++) {
			E entity = list.get(m);
			E oldEntity = oldList.get(m);
			if (compare(entity, oldEntity)) {
				// TODO
			}
		}
	}

	protected List<E> queryByEntityIds(List<E> list) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

	protected boolean compare(E entity, E oldEntity) {
		return true;
	}
	
	protected Map<String, String> getVerifyMap() {
		return null;
	}
	
	protected AbstractMapper<E, K> getMapper() {
		return null;
	}
	
	public Logger getLogger() {
		return null;
	}

}
