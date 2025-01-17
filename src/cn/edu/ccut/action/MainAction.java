package cn.edu.ccut.action;

import cn.edu.ccut.po.BestTopic;
import cn.edu.ccut.po.MainSection;
import cn.edu.ccut.po.Notice;
import cn.edu.ccut.po.Topic;
import cn.edu.ccut.service.BestTopicService;
import cn.edu.ccut.service.MainSectionService;
import cn.edu.ccut.service.NoticeService;
import cn.edu.ccut.service.TopicService;

import java.util.List;

/**
 * 主页控制
 */
public class MainAction extends BaseAction {
    private TopicService topicService;
    private MainSectionService mainSectionService;
    private NoticeService noticeService;
    private BestTopicService bestTopicService;

    //Spring注入
    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    public void setMainSectionService(MainSectionService mainSectionService) {
        this.mainSectionService = mainSectionService;
    }

    public void setNoticeService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    public void setBestTopicService(BestTopicService bestTopicService) {
        this.bestTopicService = bestTopicService;
    }

    //初始化首页推荐的帖子列表按照时间顺序
    public String initHomePage() throws Exception {
        List<Topic> latestPosts = topicService.getLatestTopic(1, 6);
        List<MainSection> mainSectionList = mainSectionService.getAllMainSection();
        List<Notice> notices = noticeService.getNotice(1, 5);
        List<BestTopic> bestTopics = bestTopicService.getBestTopicsAllow(1, 6);
        getSession().put("mainSections", mainSectionList);
        getRequest().put("notices", notices);
        getRequest().put("topics", latestPosts);
        getRequest().put("bestTopics", bestTopics);
        return "success";
    }
}
