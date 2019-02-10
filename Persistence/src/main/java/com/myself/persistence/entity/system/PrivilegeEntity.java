/**
 * 
 */
package com.myself.persistence.entity.system;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghong
 *
 */
public class PrivilegeEntity {
	
	private Long id;
	
	private Long roleId;
	
	private String menuIds;
	
	private Long menuId;
	
	public PrivilegeEntity() {
	}

	public PrivilegeEntity(Long roleId, Long menuId) {
		this.roleId = roleId;
		this.menuId = menuId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}
	
	public static PrivilegeEntity getPrivilegeEntity(Long roleId, Long menuId) {
		return new PrivilegeEntity(roleId, menuId);
	}
	
	public List<PrivilegeEntity> getPrivilegeList() {
		String[] arr = menuIds.split(",");
		List<PrivilegeEntity> list = new ArrayList<PrivilegeEntity>(arr.length);
		for(int i = 0, leg = arr.length; i < leg; i++) {
			list.add(PrivilegeEntity.getPrivilegeEntity(roleId, Long.valueOf(arr[i])));
		}
		return list;
	}

	@Override
	public String toString() {
		return "PrivilegeEntity [id=" + id + ", menuId=" + menuId + ", roleId=" + roleId + "]";
	}

}
