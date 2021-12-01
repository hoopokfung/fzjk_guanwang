package com.fzjk.guanwang.service;


import com.fzjk.guanwang.mapper.AdminMapper;
import com.fzjk.guanwang.pojo.Admin;
import com.fzjk.guanwang.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin checkAdmin(String username, String password) {
        Admin admin = adminMapper.findByUsernameAndPassword(username, MD5Utils.code(password));
        return admin;
    }
}
