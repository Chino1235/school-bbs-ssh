package cn.edu.ccut.serviceImpl;

import cn.edu.ccut.dao.ReplyDao;
import cn.edu.ccut.po.Reply;
import cn.edu.ccut.service.ReplyService;

import java.util.List;

public class ReplyServiceImpl implements ReplyService {

    private ReplyDao replyDao;

    public void setReplyDao(ReplyDao replyDao) {
        this.replyDao = replyDao;
    }

    @Override
    public boolean addReply(Reply reply) {
        try {
            replyDao.save(reply);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Reply> getReplies(int topicId, int pageIndex, int pageSize) {
        return replyDao.getReplies(topicId, pageIndex, pageSize);
    }

}
