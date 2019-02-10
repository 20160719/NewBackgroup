package com.myself.persistence.entity.system;

import java.util.Date;

import com.myself.persistence.entity.AbstractEntity;

/**
 * @author zhanghong 用户实体类
 *
 */
public class UserEntity extends AbstractEntity<Long> {

	// 账号
	private String account;

	// 密码
	private String password;

	// 姓名
	private String name;

	// 性别
	private String sex;

	// 出生日期
	private Date birthday;

	// 年龄
	private int age;
	
	// 电话号码
	private String phone;
	
	//邮箱
	private String email;

	// 地址
	private String address;
	
	//角色ID
	private Long roleId;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserEntity [name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", age=" + age + ", address="
				+ address + ", id=" + id + "]";
	}

}
