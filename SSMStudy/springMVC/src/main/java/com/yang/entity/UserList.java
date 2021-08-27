package com.yang.entity;

import lombok.Data;

import java.util.List;

@Data
public class UserList {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
