package com.java.bean;

import java.util.Objects;

public class City {
    private int cid;
    private String cname;
    private int pid;

    public City() {
    }

    public City(int cid, String cname, int pid) {
        this.cid = cid;
        this.cname = cname;
        this.pid = pid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "City{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", pid=" + pid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cid == city.cid && pid == city.pid && Objects.equals(cname, city.cname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, cname, pid);
    }
}
