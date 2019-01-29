package com.beyondlcg.springshirotest.model;

/**
 * @Author: licg
 * @Date: 2019/1/25
 * @Description：用户
 */
public class User {
    private long uid;

    private String name;

    private String password;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
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
}