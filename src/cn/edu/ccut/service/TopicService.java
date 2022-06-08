package cn.edu.ccut.service;

import cn.edu.ccut.po.Topic;

import java.util.List;

public interface TopicService {

    //获取指定Id的帖子
    public Topic getTopicById(int topicId);

    //向帖子表中增加一条记录
    public boolean publish(Topic topic);

    //更新帖子内容
    public boolean updateTopic(Topic topic);

    //根据用户id获取帖子列表 范围为一页的长度
    public List<Topic> getTopicByUserId(int userId, int pageIndex, int pageSize);

    //按照时间顺序获取最新帖子列表 范围为一页的长度
    public List<Topic> getLatestTopic(int pageIndex, int pageSize);

    List<Topic> searchTopics(String keywords);

    //自动更新帖子浏览数
    public void autoIncreaseViewNum(Topic topic);

    //自动更新帖子回复数
    public void autoIncreaseReply(Topic topic);

    //删除帖子
    public boolean deleteTopic(Topic topic);


    //按类型查找帖
    public List<Topic> getTopicByType(int type,int pageIndex,int pageSize);

}
