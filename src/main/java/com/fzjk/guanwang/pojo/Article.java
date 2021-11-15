package com.fzjk.guanwang.pojo;

import java.util.Date;

public class Article {

    private long id;
    private String title;
    private String content; //内容
    private String firstPicture; //首图

    private String flag;// 草稿？发布？
    private String editor;//编辑人
    private String status; // 待审核？审核通过？

    private Integer views;  //浏览次数
    private long tid;   //所属大类
    private long sid;   //所属小类
    private String description; //描述

    private Date createTime;
    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Article(long id, String title, String content, String firstPicture, String flag, String editor, String status, Integer views, long tid, long sid, String description, Date createTime, Date updateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.firstPicture = firstPicture;
        this.flag = flag;
        this.editor = editor;
        this.status = status;
        this.views = views;
        this.tid = tid;
        this.sid = sid;
        this.description = description;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
