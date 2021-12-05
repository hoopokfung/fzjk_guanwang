package com.fzjk.guanwang.service;


import com.fzjk.guanwang.dao.AdminRepository;
import com.fzjk.guanwang.pojo.Admin;
import com.fzjk.guanwang.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin checkAdmin(String account, String password) {
        Admin admin = adminRepository.findByAccountAndPassword(account, MD5Utils.code(password));
        return admin;
    }
}
