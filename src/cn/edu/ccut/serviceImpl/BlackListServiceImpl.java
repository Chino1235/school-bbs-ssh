package cn.edu.ccut.serviceImpl;

import cn.edu.ccut.dao.BlackListDao;
import cn.edu.ccut.po.BlackList;
import cn.edu.ccut.service.BlackListService;

import java.util.List;

public class BlackListServiceImpl implements BlackListService {
    private BlackListDao blackListDao;

    public void setBlackListDao(BlackListDao blackListDao) {
        this.blackListDao = blackListDao;
    }

    @Override
    public void save(BlackList blackListItem) {
        blackListDao.save(blackListItem);
    }

    @Override
    public void update(BlackList blackListItem) {
        blackListDao.update(blackListItem);
    }

    @Override
    public void delete(int userId) {
        blackListDao.delete(userId);
    }

    @Override
    public int getLevel(int userId) {
        return blackListDao.getLevel(userId);
    }

    @Override
    public List getAll() {
        return blackListDao.getAll();
    }
}
