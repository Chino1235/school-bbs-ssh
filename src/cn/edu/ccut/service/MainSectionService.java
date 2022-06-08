package cn.edu.ccut.service;

import cn.edu.ccut.po.MainSection;

import java.util.List;

public interface MainSectionService {
    //获取所有主板块
    public List<MainSection> getAllMainSection();

    //根据id获取主板块
    public MainSection getMainSectionById(int id);

    //添加主板库
    public boolean add(MainSection mainSection);
}
