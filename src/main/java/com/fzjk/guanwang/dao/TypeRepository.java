package com.fzjk.guanwang.dao;

import com.fzjk.guanwang.pojo.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TypeRepository extends JpaRepository<Type, Long> {

    /*通过名字查找*/
    Type findByName(String name);

    /*自定义的分页查询*/
    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}
