package org.jude.manageBack.controller;

import com.alibaba.fastjson.JSONObject;
import org.jude.manageBack.JsonRequestBody;
import org.jude.manageBack.JsonResponseBody;
import org.jude.manageBack.pojo.Activities;
import org.jude.manageBack.pojo.Orgs;
import org.jude.manageBack.service.ActivityService;
import org.jude.manageBack.service.OrgService;
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

    //查询所有活动
    @RequestMapping("/findAllActivities")
    @ResponseBody
    public JsonResponseBody findAllOrgs() throws Exception {
        List<Activities> ActivitiesList = this.activityService.findAllActivities();
        for (Activities activity : ActivitiesList) {
            int useid = activity.getOrgid();
            Orgs org = this.orgService.selectByorgID(useid);

            Date Signuptime = activity.getSignuptime();
            Date Signupendtime = activity.getSignupendtime();
            Date Activititystarttime = activity.getActivititystarttime();
            Date Activitityendtime = activity.getActivitityendtime();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date nowtime =  new Date();
            if (nowtime.after(Activitityendtime)){
                activity.setActivititystatus("已结束");
            }
            else if (nowtime.before(Signupendtime)&&nowtime.after(Signuptime)){
                activity.setActivititystatus("报名中");
            }
            else if (nowtime.before(Activititystarttime)&&nowtime.after(Signupendtime)){
                activity.setActivititystatus("活动筹备中");
            }
            else if (nowtime.before(Activitityendtime)&&nowtime.after(Activititystarttime)){
                activity.setActivititystatus("活动中");
            }else {
                activity.setActivititystatus("未开始");
            }

            activity.setOrgname(org.getOrgname());
        }
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        result.put("ActivitiesList", ActivitiesList);
        msg = "查询所有活动成功";
        code = 0;
        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //通过日历查询所有活动
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

}
