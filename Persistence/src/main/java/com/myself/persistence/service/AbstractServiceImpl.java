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
	public String deletes(List<E> list) {
		List<K> keys = getEntityIds(list);
		return deletes(keys, (l) -> getMapper().deletes(l), CommonConstant.OP_DELETES);
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
				verify(list, 1);
			} else if (opType.equals(CommonConstant.OP_UPDATES)) {
//				removeSameEntity(list);
				List<E> oldList = null;
				int size = list.size();
				try {
					oldList = queryByEntityIds(list);
					for (int i = 0; i < size; i++) {
						E entity = list.get(i);
						E oldEntity = oldList.get(i);
						if (isEqual(entity, oldEntity)) {
							// 有相同数据时删除list的该数据，不更新该数据
							list.remove(i);
							oldList.remove(i);
						} 
					}
				} catch (Exception e) {
					getLogger().error("[queryByEntityIds error] {}", e);
				}
				if(list.isEmpty()) {
					return CommonResult.OPERATE_NO.toString();
				}
				verify(list, 2);
				for(int i = 0; i < size; i++) {
					E entity = list.get(i);
					E oldEntity = oldList.get(i);
					if(null != entity && null != oldEntity) {
						setFieldNull(entity, oldEntity);
					}
				}
			}
			if (cmd.operate(list).intValue() > 0) {
				return CommonResult.OPERATE_SUCCESS.toString();
			}
		} catch (VerifyException e) {
			result = e.toString();
		} catch (ChangeException e) {
			result = e.toString();
		} catch (Exception e) {
			getLogger().error("[modifies error] {}", e);
		}
		return result;
	}
	
	protected void setFieldNull(E entity, E oldEntity) {
		//TODO
	}
	
	protected String deletes(List<K> list, ModifyOperate<K, Integer> cmd, String opType) {
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

	private void verify(List<E> list, int num) throws VerifyException {
		for (E entity : list) {
			verifyEntity(entity, num);
		}
	}

	protected void verifyEntity(E entity, int num) throws VerifyException {
		int sum = 0;
		String msg = null;
		try {
			List<Integer> list = getMapper().queryForVerify(entity);
			List<String> errorMsg = null;
			for (int i = 0, size = list.size(); i < size; i++) {
				int r = list.get(i).intValue();
				if (num <= r) {
					if (null == errorMsg) {
						errorMsg = new ArrayList<String>(size);
					}
					errorMsg.add(getVerifyMap().get(String.valueOf(i)));
					sum++;
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

	protected void removeSameEntity(List<E> list) throws ChangeException {
		try {
			List<E> oldList = queryByEntityIds(list);
			for (int m = 0, size = list.size(); m < size; m++) {
				E entity = list.get(m);
				E oldEntity = oldList.get(m);
				if (isEqual(entity, oldEntity)) {
					// 有相同数据时删除list的该数据，不更新该数据
					list.remove(entity);
				} 
			}
		} catch (Exception e) {
			getLogger().error("[queryByEntityIds error] {}", e);
		}
	}

	protected List<E> queryByEntityIds(List<E> list) throws Exception {
		return getMapper().queryByIds(getEntityIds(list));
	}
	
	protected List<K> getEntityIds(List<E> list) {
		return null;
	}

	protected boolean isEqual(E entity, E oldEntity) {
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
