package com.myself.persistence.entity;

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
	protected int page;
	
	//页大小
	protected int limit;

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

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
