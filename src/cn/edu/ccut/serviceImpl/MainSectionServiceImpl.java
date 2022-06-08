package cn.edu.ccut.serviceImpl;

import cn.edu.ccut.dao.MainSectionDao;
import cn.edu.ccut.po.MainSection;
import cn.edu.ccut.service.MainSectionService;

import java.util.List;

public class MainSectionServiceImpl implements MainSectionService {
    MainSectionDao mainSectionDao;

    public void setMainSectionDao(MainSectionDao mainSectionDao) {
        this.mainSectionDao = mainSectionDao;
    }

    @Override
    public List<MainSection> getAllMainSection() {
        return mainSectionDao.findAll();
    }

    @Override
    public MainSection getMainSectionById(int id) {
        return mainSectionDao.findById(id);
    }

    @Override
    public boolean add(MainSection mainSection) {
        List<MainSection> mains = mainSectionDao.findByTitle(mainSection.getTitle());
        if (mains.size() < 1) {  //这个主板块标题不存在 保证没有重名的主板块
            mainSectionDao.save(mainSection);
            return true;
        } else
            return false;
    }
}
