package cn.edu.ccut.action;

import cn.edu.ccut.po.Notice;
import cn.edu.ccut.po.User;
import cn.edu.ccut.service.NoticeService;

import java.sql.Timestamp;
import java.util.Date;

public class NoticeAction extends BaseAction {
    private Notice notice;

    private NoticeService noticeService;

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public NoticeService getNoticeService() {
        return noticeService;
    }

    public void setNoticeService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    public String postNotice() throws Exception {
        User admin = (User) getSession().get("user");
        if (notice != null && notice.getTitle() != null && notice.getContent() != null && admin.getPrivilege() == 1) {
            notice.setCreateTime(new Timestamp(System.currentTimeMillis()));
            notice.setUserByUserId(admin);
            noticeService.publish(notice);
            this.addFieldError("notice_result", "发表成功");
            return SUCCESS;
        }
        return ERROR;
    }

    public String notice() {
        if(notice!=null && notice.getId()>=0){
            Notice not = noticeService.getNoticeById(notice.getId());
            if(not==null)
                return ERROR;
            getRequest().put("notice", not);
            return SUCCESS;
        }
        return ERROR;
    }
}
