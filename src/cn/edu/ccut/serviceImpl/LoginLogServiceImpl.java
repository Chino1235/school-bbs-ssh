package cn.edu.ccut.serviceImpl;

import cn.edu.ccut.dao.LoginLogDao;
import cn.edu.ccut.po.LoginLog;
import cn.edu.ccut.service.LoginLogService;

public class LoginLogServiceImpl implements LoginLogService {
    private LoginLogDao loginLogDao;

    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    @Override
    public void log(LoginLog loginLog) {
        try {
            loginLogDao.save(loginLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
