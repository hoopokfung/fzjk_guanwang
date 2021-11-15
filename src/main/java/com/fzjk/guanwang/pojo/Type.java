package com.fzjk.guanwang.pojo;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class Type {

    private long tid;
    private String name;
    private int orderBy;    //排序

    private List<SubType> subTypes = new ArrayList<>();

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

    public List<SubType> getSubTypes() {
        return subTypes;
    }

    public void setSubTypes(List<SubType> subTypes) {
        this.subTypes = subTypes;
    }

    public Type(long tid, String name, int orderBy, List<SubType> subTypes) {
        this.tid = tid;
        this.name = name;
        this.orderBy = orderBy;
        this.subTypes = subTypes;
    }
}
