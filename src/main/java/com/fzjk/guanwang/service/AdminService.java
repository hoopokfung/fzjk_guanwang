package com.fzjk.guanwang.service;

import com.fzjk.guanwang.pojo.Admin;

public interface AdminService {
    Admin checkAdmin(String username, String password);
}
