package com.fzjk.guanwang.pojo;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_sub_type")
public class SubType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;       //子栏id

    @NotBlank(message = "子类名称不能为空")
    private String name;    //名称

    @ManyToOne //多对一
    private Type type;  //多个子类可从属于一个分类

    @OneToMany(mappedBy = "subType") //一对多
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", articles=" + articles +
                '}';
    }
}
