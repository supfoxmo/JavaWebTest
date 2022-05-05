package com.java.bean;

import java.util.Objects;

public class Dept {
    private String deptno;
    private String dname;
    private String address;
    private String enums;
    private String wages;

    public Dept() {
    }

    public Dept(String deptno, String dname, String address, String enums, String wages) {
        this.deptno = deptno;
        this.dname = dname;
        this.address = address;
        this.enums = enums;
        this.wages = wages;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEnums() {
        return enums;
    }

    public void setEnums(String enums) {
        this.enums = enums;
    }

    public String getWages() {
        return wages;
    }

    public void setWages(String wages) {
        this.wages = wages;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", address='" + address + '\'' +
                ", enums=" + enums +
                ", wages=" + wages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dept dept = (Dept) o;
        return deptno == dept.deptno && enums == dept.enums && wages == dept.wages && Objects.equals(dname, dept.dname) && Objects.equals(address, dept.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptno, dname, address, enums, wages);
    }
}
