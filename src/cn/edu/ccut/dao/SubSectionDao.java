package cn.edu.ccut.dao;

import cn.edu.ccut.po.SubSection;

import java.util.List;

public interface SubSectionDao {
    public List<SubSection> findByHql(String hql);

    public void save(SubSection subSection);

    public void delete(SubSection subSection);

    public void update(SubSection subSection);

    public SubSection findById(int id);

    public List findAll();

    public List findByMainId(int mid);

    List findByTitle(String title);

}
