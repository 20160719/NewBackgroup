/**
 * 
 */
package com.myself.persistence.entity.system;

/**
 * @author zhanghong
 *
 */
public class PrivilegeEntity {
	
	private Long id;
	
	private Long menuId;
	
	private Long roleId;

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

	@Override
	public String toString() {
		return "PrivilegeEntity [id=" + id + ", menuId=" + menuId + ", roleId=" + roleId + "]";
	}

}
