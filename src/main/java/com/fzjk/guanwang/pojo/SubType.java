package com.fzjk.guanwang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class SubType {

    private long sid;       //子栏id
    private String name;    //名字
    private long tid;       //类型id

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

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "SubType{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", tid=" + tid +
                ", articles=" + articles +
                '}';
    }
}
