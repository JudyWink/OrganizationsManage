package org.jude.manageBack.service;

import org.jude.manageBack.pojo.Activities;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ActivityService {

    //查询所有活动
    public List<Activities> findAllActivities() throws Exception;

    //发布活动
    public void pushActivity(Activities activities) throws Exception;
}
