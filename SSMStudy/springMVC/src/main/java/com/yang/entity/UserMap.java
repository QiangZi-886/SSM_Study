package com.yang.entity;

import lombok.Data;

import java.util.Map;
/*
* 自定义的封装类
* */
@Data
public class UserMap {
    private Map<String,User> users;

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }
}
