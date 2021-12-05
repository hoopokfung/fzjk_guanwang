package com.fzjk.guanwang.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;       //分类Id

    @NotBlank(message = "分类名称不能为空") //一定要和@Valid用，否则@NotBlank不起作用
    private String name;    //名字

    @OneToMany(mappedBy = "type")   // 一对多，一的一方为被维护方，mappedBy指定被维护方通过某属性链接
    private List<SubType> subTypes = new ArrayList<>(); //一个分类下面可以有多个子类

    @OneToMany(mappedBy = "type")
    private List<Article> articles = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubType> getSubTypes() {
        return subTypes;
    }

    public void setSubTypes(List<SubType> subTypes) {
        this.subTypes = subTypes;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subTypes=" + subTypes +
                ", articles=" + articles +
                '}';
    }
}
