package org.jude.manageBack.service.impl;

import org.jude.manageBack.mapper.ActivitiesMapper;
import org.jude.manageBack.mapper.RelationActivitiesMapper;
import org.jude.manageBack.pojo.Activities;
import org.jude.manageBack.pojo.ActivitiesExample;
import org.jude.manageBack.pojo.RelationActivities;
import org.jude.manageBack.pojo.RelationActivitiesExample;
import org.jude.manageBack.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivitiesMapper activitiesMapper;
    @Autowired
    private RelationActivitiesMapper relationActivitiesMapper;

    //查询所有活动
    @Override
    public List<Activities> findAllActivities() throws Exception{
        ActivitiesExample orgsExample = new ActivitiesExample();
        return this.activitiesMapper.selectByExample(orgsExample);
    }

    //通过用户id查找活动关系
    @Override
    public List<RelationActivities> selectByuserID(int userID) throws Exception {
        RelationActivitiesExample relationActivitiesExample = new RelationActivitiesExample();
        relationActivitiesExample.createCriteria().andUseridEqualTo(userID);
        return this.relationActivitiesMapper.selectByExample(relationActivitiesExample);
    }

    //通过社团id查找活动
    @Override
    public List<Activities> selectByorgID(int orgID) throws Exception {
        ActivitiesExample activitiesExample = new ActivitiesExample();
        activitiesExample.createCriteria().andOrgidEqualTo(orgID);
        return this.activitiesMapper.selectByExample(activitiesExample);
    }

    //通过活动id查找活动关系
    @Override
    public List<RelationActivities> selectByactivityID(int activityID) throws Exception {
        RelationActivitiesExample relationActivitiesExample = new RelationActivitiesExample();
        relationActivitiesExample.createCriteria().andActivitiesidEqualTo(activityID);
        return this.relationActivitiesMapper.selectByExample(relationActivitiesExample);
    }

    //通过id查找活动
    @Override
    public Activities findActivityByID(int activityID) throws Exception{
        return this.activitiesMapper.selectByPrimaryKey(activityID);
    }

    //发布活动
    @Override
    public void pushActivity(Activities activities) throws Exception{
        this.activitiesMapper.insert(activities);
    }
}
