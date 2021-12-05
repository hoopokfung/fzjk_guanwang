package com.fzjk.guanwang.dao;

import com.fzjk.guanwang.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AdminRepository extends JpaRepository<Admin, Long> {


    /*根据账号和密码查询*/
    @Transactional
    Admin findByAccountAndPassword(String account,String password);
}
