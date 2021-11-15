package com.fzjk.guanwang.pojo;

import java.util.ArrayList;
import java.util.List;

public class SubType {

    private long sid;
    private String name;
    private long tid;
    private int orderBy;    //排序
    private List<Article> articles = new ArrayList<>();

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public SubType(long sid, String name, long tid, int orderBy, List<Article> articles) {
        this.sid = sid;
        this.name = name;
        this.tid = tid;
        this.orderBy = orderBy;
        this.articles = articles;
    }
}
