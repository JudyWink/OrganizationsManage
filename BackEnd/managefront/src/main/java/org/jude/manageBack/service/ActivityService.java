package org.jude.manageBack.service;

import org.jude.manageBack.pojo.Activities;
import org.jude.manageBack.pojo.RelationActivities;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ActivityService {

    //查询所有活动
    public List<Activities> findAllActivities() throws Exception;

    //通过用户id查找活动关系
    public List<RelationActivities> selectByuserID(int userID) throws Exception;

    //通过社团id查找活动
    public  List<Activities> selectByorgID(int userID) throws Exception;

    //通过活动id查找活动关系
    public List<RelationActivities> selectByactivityID(int activityID) throws Exception;

    //通过id查找活动
    public Activities findActivityByID(int activityID) throws Exception;

    //增加一个活动关系
    public void insertrelationActivities(RelationActivities relationActivities)throws Exception;

    //发布活动
    public void pushActivity(Activities activities) throws Exception;

    //根据活动关系id删除一个活动关系
    public void delrelationActivities(int relationid)throws Exception;
}
