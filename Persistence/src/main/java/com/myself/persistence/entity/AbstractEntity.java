package com.myself.persistence.entity;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author zhanghong
 * 所有实体类必须继承此抽象实体类
 *
 */
public abstract class AbstractEntity<K> {
	
	//主键
	protected K id;
	
	//创建时间
	protected Date createTime;
	
	//修改时间
	protected Date updateTime;
	
	//页码
	protected Integer page = 1;
	
	protected Integer startIndex;
	
	//页大小
	protected Integer limit = 20;
	//0:返回表所有字段
	protected Integer dataReturnType = 0;

	public K getId() {
		return id;
	}

	public void setId(K id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getStartIndex() {
		if(null != page && null != limit) {
			return (page.intValue() - 1) * limit.intValue();
		}
		return null;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	public Integer getDataReturnType() {
		return dataReturnType;
	}

	public void setDataReturnType(Integer dataReturnType) {
		this.dataReturnType = dataReturnType;
	}

	public boolean fieldsIsChanged(AbstractEntity<K> oldEntity) {
		return fieldsIsChanged(oldEntity, true);
	}
	
	public boolean fieldsIsChanged(AbstractEntity<K> oldEntity, boolean nullFlag) {
		boolean isChange = false;
		try {
			Class<?> clazz = this.getClass();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				String name = field.getName();
				if("createTime".equals(name) || "updateTime".equals(name)) {
					continue;
				}
				PropertyDescriptor pd = new PropertyDescriptor(name, clazz);
				Method getMethod = pd.getReadMethod();
				Object o1 = getMethod.invoke(this);
				Object o2 = getMethod.invoke(oldEntity);
				String s1 = o1 == null ? "" : o1.toString();
				String s2 = o2 == null ? "" : o2.toString();
				if (!s1.equals(s2)) {
					isChange =  true;
				} else {
					if(nullFlag) {
						// 取消语言访问检查
						field.setAccessible(true);
						field.set(this, null);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isChange;
	}

}
