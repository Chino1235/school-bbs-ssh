package cn.edu.ccut.dao;

import cn.edu.ccut.po.Reply;

import java.util.List;

public interface ReplyDao {
    public List<Reply> findByHql(String hql);

    public void save(Reply reply) throws Exception;

    public void update(Reply reply) throws Exception;

    public void delete(Reply reply) throws Exception;

    public Reply findById(int id);

    //获取帖子中的全部回复
    public List<Reply> getReplies(int topicId, int pageIndex, int pageSize);

}
