package com.fzjk.guanwang.vo;

public class PreAndNextArticle {

    //上一篇或下一篇的id
    private Long id ;
    //上一篇或下一篇的标题
    private String title;

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
}
