package org.jude.manageBack.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.catalina.User;
import org.jude.manageBack.JsonRequestBody;
import org.jude.manageBack.JsonResponseBody;
import org.jude.manageBack.config.UserLoginToken;
import org.jude.manageBack.pojo.Activities;
import org.jude.manageBack.pojo.Orgs;
import org.jude.manageBack.pojo.RelationActivities;
import org.jude.manageBack.pojo.Users;
import org.jude.manageBack.service.ActivityService;
import org.jude.manageBack.service.OrgService;
import org.jude.manageBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private OrgService orgService;
    @Autowired
    private UserService userService;

    //查询所有活动
    @RequestMapping("/findAllActivities")
    @ResponseBody
    public JsonResponseBody findAllOrgs(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        JSONObject result = new JSONObject();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        try {
            List<Activities> ActivitiesList = this.activityService.findAllActivities();
            for (Activities activity : ActivitiesList) {
                int activityID = activity.getActivitityid();
                List<RelationActivities> relationActivitiesList = this.activityService.selectByactivityID(activityID);
                if(!relationActivitiesList.isEmpty()){
                    activity.setCount(relationActivitiesList.size());
                }else {
                    activity.setCount(0);
                }
                int useid = activity.getOrgid();
                Orgs org = this.orgService.selectByorgID(useid);
                activity.setOrgname(org.getOrgname());
                Date Signuptime = activity.getSignuptime();
                Date Signupendtime = activity.getSignupendtime();
                Date Activititystarttime = activity.getActivititystarttime();
                Date Activitityendtime = activity.getActivitityendtime();
                Date nowtime = new Date();
                if (nowtime.after(Activitityendtime)) {
                    activity.setActivititystatus("已结束");
                } else if (nowtime.before(Signupendtime) && nowtime.after(Signuptime)) {
                    activity.setActivititystatus("报名中");
                } else if (nowtime.before(Activititystarttime) && nowtime.after(Signupendtime)) {
                    activity.setActivititystatus("活动筹备中");
                } else if (nowtime.before(Activitityendtime) && nowtime.after(Activititystarttime)) {
                    activity.setActivititystatus("活动中");
                } else {
                    activity.setActivititystatus("未开始");
                }
            }
            result.put("ActivitiesList", ActivitiesList);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "查询所有活动失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        msg = "查询所有活动成功";
        code = 0;
        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //通过日历查询所有活动
    @UserLoginToken
    @RequestMapping("/CalendarFind")
    @ResponseBody
    public JsonResponseBody CalendarFind() throws Exception {
        List<Activities> ActivitiesList = this.activityService.findAllActivities();
        List<JSONObject> list = new ArrayList<JSONObject>();
        for (Activities activity : ActivitiesList) {
            JSONObject calendarThings =  new JSONObject();
            String content =  activity.getActivitityname();
            Date startDate = activity.getActivititystarttime();
            calendarThings.put("date",startDate);
            calendarThings.put("content",content);
            list.add(calendarThings);
        }
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        msg = "查询所有活动成功";
        code = 0;
        JSONObject result = new JSONObject();
        result.put("resDate", list);
        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //发布活动
    @UserLoginToken
    @RequestMapping("/pushActivity")
    @ResponseBody
    public JsonResponseBody pushActivity(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        JSONObject form = data.getJSONObject("Form");
        Activities activities = new Activities();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        try {
            String signupTime = form.getString("signupTime");
            signupTime = signupTime.replaceAll("\\[","");
            signupTime = signupTime.replaceAll("]","");
            signupTime = signupTime.replaceAll("\"","");
            String activitityTime = form.getString("activitityTime");
            activitityTime = activitityTime.replaceAll("\\[","");
            activitityTime = activitityTime.replaceAll("]","");
            activitityTime = activitityTime.replaceAll("\"","");
            String[] signupTimesplit = signupTime.split(",");
            String[] activitityTimesplit = activitityTime.split(",");
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date Signuptime = sf.parse(signupTimesplit[0]);
            Date Signupendtime = sf.parse(signupTimesplit[1]);
            Date Activititystarttime = sf.parse(activitityTimesplit[0]);
            Date Activitityendtime = sf.parse(activitityTimesplit[1]);
            activities.setSignuptime(Signuptime);
            activities.setSignupendtime(Signupendtime);
            activities.setActivititystarttime(Activititystarttime);
            activities.setActivitityendtime(Activitityendtime);
            activities.setActivitityname(form.getString("activitityName"));
            activities.setOrgid(data.getInteger("orgID"));
            activities.setActivitityscount(form.getInteger("activititysCount"));
            activities.setActivititytype(form.getString("activitityType"));
            activities.setActivititydescribe(form.getString("activitityDescribe"));
            activities.setActivitityplace(form.getString("activitityPlace"));
            this.activityService.pushActivity(activities);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "发布活动失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        msg = "活动发布成功";
        code = 0;
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //查找一个活动
    @UserLoginToken
    @RequestMapping("/findOneActivity")
    @ResponseBody
    public JsonResponseBody findOneActivity(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        String msg = null;
        Integer code = null;
        try {
            int userID = data.getInteger("userID");
            int activityID = data.getInteger("activityID");
            List<RelationActivities> relationActivitiesList = this.activityService.selectByactivityID(activityID);
            Activities activitity = this.activityService.findActivityByID(activityID);
            if(!relationActivitiesList.isEmpty()){
                for(RelationActivities relationActivities:relationActivitiesList){
                    int joinUser = relationActivities.getUserid();
                    if(joinUser == userID){
                        activitity.setSingup("false");
                    }else {
                        activitity.setSingup("true");
                    }
                }
                result.put("count" ,relationActivitiesList.size());
            }else {
                result.put("count" ,0);
                activitity.setSingup("true");
            }
            int useid = activitity.getOrgid();
            Orgs org = this.orgService.selectByorgID(useid);
            activitity.setOrgname(org.getOrgname());
            Date Signuptime = activitity.getSignuptime();
            Date Signupendtime = activitity.getSignupendtime();
            Date Activititystarttime = activitity.getActivititystarttime();
            Date Activitityendtime = activitity.getActivitityendtime();
            Date nowtime =  new Date();
            if (nowtime.after(Activitityendtime)){
                activitity.setActivititystatus("4");
            }
            else if (nowtime.before(Signupendtime)&&nowtime.after(Signuptime)){
                activitity.setActivititystatus("2");
            }
            else if (nowtime.before(Activititystarttime)&&nowtime.after(Signupendtime)){
                activitity.setActivititystatus("2");
            }
            else if (nowtime.before(Activitityendtime)&&nowtime.after(Activititystarttime)){
                activitity.setActivititystatus("3");
            }else {
                activitity.setActivititystatus("1");
            }

            result.put("activitityInfo", activitity);
            msg = "成功查询到活动";
            code = 0;
        } catch (Exception e) {
            e.printStackTrace();
            msg = "查询活动失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //查找参加的所有活动
    @UserLoginToken
    @RequestMapping("/findMyActivities")
    @ResponseBody
    public JsonResponseBody findMyActivities(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        String msg = null;
        Integer code = null;
        try {
            int userID = data.getInteger("userID");
            List<RelationActivities> relationActivitiesList = this.activityService.selectByuserID(userID);
            for(RelationActivities relationActivities:relationActivitiesList){
                Activities activities = this.activityService.findActivityByID(relationActivities.getActivitiesid());
                relationActivities.setActname(activities.getActivitityname());
            }
            result.put("ActivitiesList",relationActivitiesList);
            msg = "查询参加的活动成功";
            code = 0;
        } catch (Exception e) {
            e.printStackTrace();
            msg = "查询活动失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //查找发布所有活动
    @UserLoginToken
    @RequestMapping("/findMyPushActivities")
    @ResponseBody
    public JsonResponseBody findMyPushActivities(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        String msg = null;
        Integer code = null;
        try {
            int orgID = data.getInteger("orgID");
            List<Activities> activities = this.activityService.selectByorgID(orgID);
            List<JSONObject> ActivitiesList = new ArrayList<>();
            for (Activities activities1 :activities) {
                JSONObject ActivitiesObject = new JSONObject();
                ActivitiesObject.put("activitiesid", activities1.getActivitityid());
                ActivitiesObject.put("actname",activities1.getActivitityname());
                ActivitiesList.add(ActivitiesObject);
            }
            result.put("ActivitiesList", ActivitiesList);
            msg = "查询发布的活动成功";
            code = 0;
        } catch (Exception e) {
            e.printStackTrace();
            msg = "查询活动失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //报名活动
    @UserLoginToken
    @RequestMapping("/actSingup")
    @ResponseBody
    public JsonResponseBody actSingup(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        String msg = null;
        Integer code = null;
        try {
            int userID = data.getInteger("userID");
            int activityID = data.getInteger("activityID");
            Activities activities = this.activityService.findActivityByID(activityID);
            List<RelationActivities> relationActivitiesList = this.activityService.selectByactivityID(activityID);
            Date Signuptime = activities.getSignuptime();
            Date Signupendtime = activities.getSignupendtime();
            int count = activities.getActivitityscount();
            Date notime = new Date();
            if(notime.before(Signupendtime)&& notime.after(Signuptime)){
                if(!relationActivitiesList.isEmpty() && relationActivitiesList.size()>count){
                    msg = "报名人数已满";
                    code = 1;
                    responseBody.setMsg(msg);
                    responseBody.setCode(code);
                    return responseBody;
                }else {
                    RelationActivities relationActivities = new RelationActivities();
                    relationActivities.setUserid(userID);
                    relationActivities.setSinuptime(notime);
                    relationActivities.setActivitiesid(activityID);
                    this.activityService.insertrelationActivities(relationActivities);
                    msg = "报名活动成功";
                    code = 0;
                }
            }else {
                msg = "不在报名时间段内";
                code = 1;
                responseBody.setMsg(msg);
                responseBody.setCode(code);
                return responseBody;
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "报名活动失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //查找报名了该活动的学生
    @UserLoginToken
    @RequestMapping("/findSingupStudents")
    @ResponseBody
    public JsonResponseBody findSingupStudents(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        String msg = null;
        Integer code = null;
        try {
            int activityID = data.getInteger("activityID");
            List<RelationActivities> relationActivitiesList = this.activityService.selectByactivityID(activityID);
            List<JSONObject> usersList = new ArrayList<>();
            for (RelationActivities relationActivities:relationActivitiesList){
                int userID = relationActivities.getUserid();
                Users users = this.userService.selectByuserID(userID);
                JSONObject userInfo = new JSONObject();
                String orgID = users.getDefultorg();
                if (orgID != null) {
                    if (orgID.equals("")) {
                        userInfo.put("orgname", "【未加入社团】");
                    } else {
                        Orgs orgs = this.orgService.selectByorgID(Integer.valueOf(orgID));
                        userInfo.put("orgname", orgs.getOrgname());
                    }
                }else {
                    userInfo.put("orgname", "【未加入社团】");
                }
                userInfo.put("username",users.getUsername());
                userInfo.put("useracademy",users.getUseracademy());
                userInfo.put("userclass",users.getUserclass());
                userInfo.put("userphone",users.getUserphone());
                userInfo.put("usernumber",users.getUsernumber());
                userInfo.put("Sinuptime",relationActivities.getSinuptime());
                userInfo.put("userid",users.getUserid());
                userInfo.put("relationid",relationActivities.getRelationActivitiesId());
                usersList.add(userInfo);
            }
            result.put("usersList",usersList);
            msg = "查找报名该活动的学生成功";
            code = 0;
        } catch (Exception e) {
            e.printStackTrace();
            msg = "查找报名该活动的学生失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //查找报名了该活动的学生
    @UserLoginToken
    @RequestMapping("/fireFromActivity")
    @ResponseBody
    public JsonResponseBody fireFromActivity(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        String msg = null;
        Integer code = null;
        try {
            int relationid = data.getInteger("relationid");
            this.activityService.delrelationActivities(relationid);
            msg = "成功将学生移除本活动";
            code = 0;
        } catch (Exception e) {
            e.printStackTrace();
            msg = "将学生移除本活动失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }


}
