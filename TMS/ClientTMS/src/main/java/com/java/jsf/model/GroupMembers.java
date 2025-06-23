package com.java.jsf.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class GroupMembers implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
    private Groups group;
    private Users user;
    private LocalDateTime joinedAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Groups getGroup() {
		return group;
	}
	public void setGroup(Groups group) {
		this.group = group;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public LocalDateTime getJoinedAt() {
		return joinedAt;
	}
	public void setJoinedAt(LocalDateTime joinedAt) {
		this.joinedAt = joinedAt;
	}
	public GroupMembers(int id, Groups group, Users user, LocalDateTime joinedAt) {
		super();
		this.id = id;
		this.group = group;
		this.user = user;
		this.joinedAt = joinedAt;
	}
	public GroupMembers() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
