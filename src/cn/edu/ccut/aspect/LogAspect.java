package cn.edu.ccut.aspect;

import cn.edu.ccut.po.LoginLog;
import cn.edu.ccut.service.LoginLogService;
import cn.edu.ccut.util.HttpUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;

public class LogAspect {
    private void recordLog() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        LoginLogService loginLogService = (LoginLogService) context.getBean("loginLogService");
        LoginLog loginLog = new LoginLog();
        String ip = HttpUtil.getIpAddress();
        String info = HttpUtil.getOsAndBrowserInfo();
        loginLog.setIp(ip);
        loginLog.setDevice(info);
        loginLog.setLoginTime(new Timestamp(System.currentTimeMillis()));
        loginLogService.log(loginLog);
    }
}

