package com.java.bean;

import java.util.Objects;

public class Province {
    private int pid;
    private String pname;
    private String jiancheng;
    private String shenghui;

    public Province() {
    }

    public Province(int pid, String pname, String jiancheng, String shenghui) {
        this.pid = pid;
        this.pname = pname;
        this.jiancheng = jiancheng;
        this.shenghui = shenghui;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getJiancheng() {
        return jiancheng;
    }

    public void setJiancheng(String jiancheng) {
        this.jiancheng = jiancheng;
    }

    public String getShenghui() {
        return shenghui;
    }

    public void setShenghui(String shenghui) {
        this.shenghui = shenghui;
    }

    @Override
    public String toString() {
        return "Province{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", jiancheng='" + jiancheng + '\'' +
                ", shenghui='" + shenghui + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Province province = (Province) o;
        return pid == province.pid && Objects.equals(pname, province.pname) && Objects.equals(jiancheng, province.jiancheng) && Objects.equals(shenghui, province.shenghui);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, pname, jiancheng, shenghui);
    }
}
