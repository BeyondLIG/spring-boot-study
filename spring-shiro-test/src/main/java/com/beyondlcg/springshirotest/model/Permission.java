package com.beyondlcg.springshirotest.model;

/**
 * @Author: licg
 * @Date: 2019/1/25
 * @Description：权限
 */
public class Permission {
    private long pid;

    private String url;

    private String name;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}