package cn.edu.ccut.action;

import cn.edu.ccut.po.Topic;
import cn.edu.ccut.service.TopicService;

import java.util.List;

/**
 * 搜索
 */

public class SearchAction extends BaseAction{

    private String keywords;
    private TopicService topicService;

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    public String execute() throws Exception {
        System.out.println(keywords);
        List<Topic> topics = topicService.searchTopics(keywords);
        if(topics.size()==0){
            topics=null;
        }
        getRequest().put("topics", topics);
        return SUCCESS;
    }
}
