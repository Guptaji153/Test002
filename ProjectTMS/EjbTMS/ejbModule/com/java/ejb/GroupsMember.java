package com.java.ejb;

import java.io.Serializable;
import java.sql.Timestamp;

public class GroupsMember implements Serializable {

    private int id;
    private Group group = new Group();
    private User user = new User();
    private Timestamp joinedAt;
    private boolean isAdmin;

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    public GroupsMember() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroupsMember(int id, Group group, User user, Timestamp joinedAt, boolean isAdmin) {
		super();
		this.id = id;
		this.group = group;
		this.user = user;
		this.joinedAt = joinedAt;
		this.isAdmin = isAdmin;
	}

	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getJoinedAt() {
        return joinedAt;
    }
    public void setJoinedAt(Timestamp joinedAt) {
        this.joinedAt = joinedAt;
    }

    @Override
    public String toString() {
        return "GroupsMember [id=" + id + ", group=" + group.getName() +
               ", user=" + user.getName() + ", joinedAt=" + joinedAt + "]";
    }
}
