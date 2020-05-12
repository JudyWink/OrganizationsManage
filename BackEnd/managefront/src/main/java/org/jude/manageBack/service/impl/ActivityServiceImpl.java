package org.jude.manageBack.service.impl;

import org.jude.manageBack.mapper.ActivitiesMapper;
import org.jude.manageBack.pojo.Activities;
import org.jude.manageBack.pojo.ActivitiesExample;
import org.jude.manageBack.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivitiesMapper activitiesMapper;

    //查询所有活动
    @Override
    public List<Activities> findAllActivities() throws Exception{
        ActivitiesExample orgsExample = new ActivitiesExample();
        return this.activitiesMapper.selectByExample(orgsExample);
    }
}
