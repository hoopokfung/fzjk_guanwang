package com.fzjk.guanwang.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;          //管理员id
    private String account;   //手机号
    private String password;  //密码
    private String avatar;    //头像
    private String nickname;  //昵称
    private String email;     //邮箱
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;  //创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;  //更新时间


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
