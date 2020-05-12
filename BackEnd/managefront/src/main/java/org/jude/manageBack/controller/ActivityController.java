package org.jude.manageBack.controller;

import com.alibaba.fastjson.JSONObject;
import org.jude.manageBack.JsonResponseBody;
import org.jude.manageBack.pojo.Activities;
import org.jude.manageBack.pojo.Orgs;
import org.jude.manageBack.service.ActivityService;
import org.jude.manageBack.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private OrgService orgService;

    @RequestMapping("/findAllActivities")
    @ResponseBody
    public JsonResponseBody findAllOrgs() throws Exception {
        List<Activities> ActivitiesList = this.activityService.findAllActivities();
        for(Activities activity: ActivitiesList){
            int useid = activity.getOrgid();
            Orgs org = this.orgService.selectByorgID(useid);
            activity.setOrgname(org.getOrgname());
        }
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        result.put("ActivitiesList",ActivitiesList);
        msg = "查询所有活动成功";
        code = 0;
        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }
}
