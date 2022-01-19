package com.fzjk.guanwang.vo;

import com.fzjk.guanwang.pojo.SubType;
import com.fzjk.guanwang.pojo.Type;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class ArticleQuery {
    private Long id;
    private String title;
    private String description;
    @Temporal(TemporalType.TIMESTAMP) //TIMESTAMP表示yyyy-MM-dd HH:mm:ss
    private Date updateTime;        //更新时间

    private String firstPicture;    //首图
    private String editor;          //编辑人

    private Boolean published;       //草稿？发布？
    private Integer views;          //浏览次数

    @ManyToOne //指定对应关系为多对一
    private Type type;  //多个文章可从属于一个分类

    @ManyToOne //多对一
    private SubType subType; //多个文章可从属于一个子类，与SubType类的@OnetoMany中的mappedBy = "subType"对应

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public SubType getSubType() {
        return subType;
    }

    public void setSubType(SubType subType) {
        this.subType = subType;
    }

    @Override
    public String toString() {
        return "ArticleQuery{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", updateTime=" + updateTime +
                ", firstPicture='" + firstPicture + '\'' +
                ", editor='" + editor + '\'' +
                ", published=" + published +
                ", views=" + views +
                ", type=" + type +
                ", subType=" + subType +
                '}';
    }
}
