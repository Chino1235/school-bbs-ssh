package cn.edu.ccut.service;

import cn.edu.ccut.po.User;

public interface AdminService {


    User getAdminById(Integer id);

    void updateAdmin(User admin);

    boolean existEmail(User admin);

    boolean existUsername(User admin);

    int getAdminIdByUsername(String username);

    int getAdminIdByEmail(String email);

}
