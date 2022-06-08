package cn.edu.ccut.dao;

import cn.edu.ccut.po.BlackList;

import java.util.List;

public interface BlackListDao {
    void save(BlackList blackListItem);

    void update(BlackList blackListItem);

    void delete(int userId);

    int getLevel(int userId);

    List getAll();

}
