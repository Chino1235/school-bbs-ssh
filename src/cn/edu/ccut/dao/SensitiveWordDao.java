package cn.edu.ccut.dao;

import cn.edu.ccut.po.SensitiveWord;

import java.util.List;

public interface SensitiveWordDao {

    void save(SensitiveWord sensetiveWord);
    void delete(SensitiveWord sensitiveWord);
    void update(SensitiveWord sensitiveWord);

    List findById(int id);

    List findAll();

}
