package com.myself.persistence.entity.system;

import com.myself.persistence.entity.AbstractEntity;

/**
 * @author zhanghong
 *
 */
public class TreeEntity extends AbstractEntity<Long> {

	// 类型（0 菜单 1 角色）
	private Integer type;

	// 父级ID
	private Long pId;

	// 名称
	private String name;

	// 值
	private String value;

	// 用途
	private Integer useType;

	// 层级
	private Integer level;

	// 序列
	private Integer seq;

	// 描述
	private String description;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getPId() {
		return pId;
	}

	public void setPId(Long pId) {
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

	public Integer getUseType() {
		return useType;
	}

	public void setUseType(Integer useType) {
		this.useType = useType;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean fieldsIsChanged(AbstractEntity<Long> oldEntity) {
		TreeEntity oldTEty = (TreeEntity) oldEntity;
		return super.fieldsIsChanged(oldTEty);
	}

	@Override
	public String toString() {
		return "TreeEntity [type=" + type + ", pId=" + pId + ", name=" + name + ", value=" + value + ", useType="
				+ useType + ", level=" + level + ", seq=" + seq + ", description=" + description + ", id=" + id + "]";
	}

}
