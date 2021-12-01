package com.fzjk.guanwang.mapper;


import com.fzjk.guanwang.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeMapper {

    List<Type> queryTypeList();

    Type queryTypeById(int id);

    int addType(Type type);

    int updateType(Type type);

    int deleteType(int id);
}
