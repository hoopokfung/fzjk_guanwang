package com.fzjk.guanwang.pojo;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                //文章id

    private String title;           //标题

    @Basic(fetch = FetchType.LAZY)  //懒加载表示，初始化时不加载该属性，只有在调用时才加载;EAGER(即时加载，默认值）即实例化时必须加载该属性
    @Lob //@Lob注解声明大字段类型 第一次初始时才有效，一般和@Basic懒加载一起使用，只有需要获取的时候才去查询，也可以直接去数据库内将该字段改为longtext类型
    private String content;         //内容

    private String firstPicture;    //首图
    private String flag;            //草稿？发布？
    private String editor;          //编辑人
    private String status;          //待审核？审核通过？

    private Integer views;          //浏览次数
    private String description;     //描述
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;        //创建时间
    @Temporal(TemporalType.TIMESTAMP) //TIMESTAMP表示yyyy-MM-dd HH:mm:ss
    private Date updateTime;        //更新时间

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
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", editor='" + editor + '\'' +
                ", status='" + status + '\'' +
                ", views=" + views +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", type=" + type +
                ", subType=" + subType +
                '}';
    }
}
