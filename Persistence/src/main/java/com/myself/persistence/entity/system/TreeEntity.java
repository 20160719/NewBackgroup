package com.myself.persistence.entity.system;

import com.myself.persistence.entity.AbstractEntity;

/**
 * @author zhanghong
 *
 */
public class TreeEntity extends AbstractEntity<Long> {
	
	//类型（0 菜单 1 角色）
	private int type;
	
	//父级ID
	private Long pId;
	
	//名称
	private String name;
	
	//值
	private String value;
	
	//用途
	private int useType;
	
	//层级
	private int level;
	
	//序列
	private int seq;
	
	//描述
	private String description;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getUseType() {
		return useType;
	}

	public void setUseType(int useType) {
		this.useType = useType;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TreeEntity [type=" + type + ", pId=" + pId + ", name=" + name + ", value=" + value + ", level=" + level
				+ ", seq=" + seq + ", description=" + description + ", id=" + id + "]";
	}

}
