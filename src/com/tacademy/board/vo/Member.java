package com.tacademy.board.vo;

import java.io.Serializable;

public class Member implements Serializable {

	private static final long serialVersionUID = -1130677687103217857L;
	
	private int num;
	private String id;
	private String name;
	private String password;
	private String role;

	public Member() {}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", id=" + id + ", name=" + name + ", password=" + password + ", role=" + role
				+ "]";
	}
}
