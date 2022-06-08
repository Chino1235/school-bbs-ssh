package cn.edu.ccut.dao;

import cn.edu.ccut.po.MainSection;

import java.util.List;

/**
 * @author 鲍锋雄
 */
public interface MainSectionDao {
    public List<MainSection> findByHql(String hql);

    public void save(MainSection mainSection);

    public void delete(MainSection mainSection);

    public void update(MainSection mainSection);

    public MainSection findById(int id);

    public List findAll();

    public List findByTitle(String title);

    public List findByDesc(String desc);

}
