package com.beyondlcg.springshirotest.model;

/**
 * @Author: licg
 * @Date: 2019/1/25
 * @Description：角色
 */
public class Role {
    private long rid;

    private String name;

    private String memo;

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}