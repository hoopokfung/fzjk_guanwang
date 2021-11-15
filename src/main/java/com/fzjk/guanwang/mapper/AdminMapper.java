package com.fzjk.guanwang.mapper;

import com.fzjk.guanwang.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


//这个注解表示了这是一个mybatis的mapper类：Dao
@Mapper
@Repository
public interface AdminMapper {

    List<Admin> queryAdminList();

    Admin queryAdminById(int id);

    int addAdmin(Admin admin);

    int updateAdmin(Admin admin);

    int deleteAdmin(int id);
}
