package cn.edu.ccut.dao;

import cn.edu.ccut.po.BestTopic;

import java.util.List;

public interface BestTopicDao {
    public void save(BestTopic topic) throws Exception;

    public List<BestTopic> getBestTopics(int pageIndex, int pageSize);

    public List<BestTopic> getBestTopics();

    public List<BestTopic> getBestTopicsAllow(int pageIndex, int pageSize);

    public void delete(int postId);

    public void updateState(int topicId, int state) throws Exception;

    public List<BestTopic> getTopicsByUserId(int userId, int pageIndex, int pageSize);

    public boolean isExist(int postId);
}
