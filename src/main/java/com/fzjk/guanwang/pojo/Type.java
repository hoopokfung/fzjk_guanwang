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
public class Type {

    private long tid;       //分类Id
    private String name;    //名字

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

    public List<SubType> getSubTypes() {
        return subTypes;
    }

    public void setSubTypes(List<SubType> subTypes) {
        this.subTypes = subTypes;
    }


    @Override
    public String toString() {
        return "Type{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", subTypes=" + subTypes +
                '}';
    }
}
