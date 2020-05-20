package org.jude.manageBack.controller;

import com.alibaba.fastjson.JSONObject;
import org.jude.manageBack.JsonRequestBody;
import org.jude.manageBack.JsonResponseBody;
import org.jude.manageBack.config.UserLoginToken;
import org.jude.manageBack.pojo.*;
import org.jude.manageBack.service.IndexService;
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
import java.util.Iterator;
import java.util.List;

@Controller
public class OrgContorller {
    @Autowired
    private OrgService orgService;
    @Autowired
    private UserService userService;
    @Autowired
    private IndexService indexService;


    //查询所有社团
    @RequestMapping("/findAllOrgs")
    @ResponseBody
    public JsonResponseBody findAllOrgs() throws Exception {
        List<Orgs> orgsList = this.orgService.findAllOrgs();
        Iterator<Orgs> iterator = orgsList.iterator();
        while (iterator.hasNext()) {
            Orgs orgs = iterator.next();
            if (orgs.getOrgid() == 9999) {
                iterator.remove();//使用迭代器的删除方法删除
            }
        }
        for (Orgs Org : orgsList) {
            int useid = Org.getOrgleader();
            Users user = this.userService.selectByuserID(useid);
            int orgID = Org.getOrgid();
            List<RelationOrgs> relationOrgs = this.orgService.selectRelByorgID(orgID);
            Org.setorgMmuberCount(String.valueOf(relationOrgs.size()));
            Org.setLeadername(user.getUsername());
        }
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        result.put("orgsList", orgsList);
        msg = "查询所有社团成功";
        code = 0;
        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //根据ID查询社团
    @RequestMapping("/findOneOrg")
    @ResponseBody
    public JsonResponseBody findOneOrg(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        try {
            if (data.containsKey("orgID") && !requestBody.getData().getString("orgID").equals("")) {
                int orgID = data.getInteger("orgID");
                Orgs org = this.orgService.selectByorgID(orgID);
                result.put("org", org);
                msg = "根据ID查询社团成功";
                code = 0;
            } else {
                Orgs org = new Orgs();
                org.setOrghistory("无");
                org.setOrgintroduce("无");
                org.setOrgname("你还没加入社团!");
                result.put("org", org);
                msg = "根据ID查询社团成功";
                code = 0;
            }
        } catch (Exception e) {
            msg = "根据ID查询社团失败";
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


    //查询本社团所有图片
    @RequestMapping("/findAllOrgImgs")
    @ResponseBody
    public JsonResponseBody findAllOrgImgs(@RequestBody JsonRequestBody requestBody) throws Exception {
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        try {
            if (requestBody.getData().containsKey("orgID") && !requestBody.getData().getString("orgID").equals("")) {
                int orgID = requestBody.getData().getInteger("orgID");
                List<Indeximgs> imgsINFO = this.indexService.findImgsbyOrg(orgID);
                List<String> IndexImgsUrls = new ArrayList<String>();
                if (!imgsINFO.isEmpty()) {
                    for (Indeximgs list : imgsINFO) {
                        String url = list.getIndeximgurl();
                        IndexImgsUrls.add(url);
                    }
                    result.put("IndexImgsUrls", IndexImgsUrls);
                    result.put("count", imgsINFO.size());
                    msg = "查找社团图片成功";
                    code = 0;
                } else {
                    msg = "数据库中没找到社团图片信息";
                    code = 1;
                }
            } else {
                msg = "你还没加入社团";
                code = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "查找社团图片失败";
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


    //设置社团图片
    @UserLoginToken
    @RequestMapping("/upLoadOrgImgs")
    @ResponseBody
    public JsonResponseBody upLoadOrgImgs(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        String url = data.getString("url");
        String userAccount = data.getString("userAccount");
        int orgID = requestBody.getData().getInteger("orgID");
        Indeximgs indeximgs = new Indeximgs();
        indeximgs.setIndeximgurl(url);
        indeximgs.setIndeximgownerorg(orgID);
        SimpleDateFormat nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        indeximgs.setIndeximgcreatetime(nowtime.parse(nowtime.format(new Date())));
        indeximgs.setIndeximgowner(userAccount);
        this.indexService.upLoadIndexImgs(indeximgs);
        msg = "成功设置社团首页图片";
        code = 0;

        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //查找社团成员
    @UserLoginToken
    @RequestMapping("/findOrgMembers")
    @ResponseBody
    public JsonResponseBody findOrgMembers(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        JSONObject result = new JSONObject();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        try {
            List<JSONObject> usersList = new ArrayList<>();
            int orgID = data.getInteger("orgID");
            List<RelationOrgs> relationOrgs = this.orgService.selectRelByorgID(orgID);
            for (RelationOrgs relationOrgsList : relationOrgs) {
                int userID = relationOrgsList.getUserid();
                Users users = this.userService.selectByuserID(userID);
                JSONObject userObject = new JSONObject();
                userObject.put("username", users.getUsername());
                userObject.put("phone", users.getUserphone());
                userObject.put("userid", users.getUserid());
                userObject.put("department", relationOrgsList.getDepartment());
                userObject.put("position", relationOrgsList.getPosition());
                userObject.put("joinTime", relationOrgsList.getJointime());
                usersList.add(userObject);
            }
            result.put("tableData", usersList);
            result.put("membersCount", usersList.size());
            msg = "查找社团成员成功";
            code = 0;
        } catch (Exception e) {
            e.printStackTrace();
            msg = "查找社团成员失败";
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

    //查找社团成员
    @UserLoginToken
    @RequestMapping("/promotedMembers")
    @ResponseBody
    public JsonResponseBody promotedMembers(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        JSONObject result = new JSONObject();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        try {
            int userID = data.getInteger("userID");
            int orgID = data.getInteger("orgID");
            String department = data.getString("department");
            String Position = data.getString("Position");
            RelationOrgs relationOrgs = new RelationOrgs();
            relationOrgs.setUserid(userID);
            relationOrgs.setOrgid(orgID);
            relationOrgs.setDepartment(department);
            relationOrgs.setPosition(Position);
            this.orgService.updaterelationOrgsOneInfo(relationOrgs, userID);
            msg = "设置成员部门信息成功";
            code = 0;
        } catch (Exception e) {
            e.printStackTrace();
            msg = "设置成员部门信息失败";
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

    //查找社团成员
    @UserLoginToken
    @RequestMapping("/signUpOrg")
    @ResponseBody
    public JsonResponseBody signUpOrg(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        JSONObject result = new JSONObject();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        try {
            int userID = data.getInteger("userID");
            int orgID = data.getInteger("orgID");
            Signuporg signuporg = new Signuporg();
            signuporg.setUserid(userID);
            signuporg.setOrgid(orgID);
            signuporg.setSignuporgtime(new Date());
            signuporg.setIsnotadmission("否");
            this.orgService.insertsignUpOrg(signuporg);
            msg = "报名社团成功";
            code = 0;
        } catch (Exception e) {
            e.printStackTrace();
            msg = "报名社团失败";
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


    //查询报名社团学生
    @RequestMapping("/findsignUpUser")
    @ResponseBody
    @UserLoginToken
    public JsonResponseBody findsignUpUser(@RequestBody JsonRequestBody requestBody) throws Exception {
        List<Users> usersList = new ArrayList<>();
        List<Signuporg> signuporgs = this.orgService.findAllsignUpOrg();
        JSONObject data = requestBody.getData();
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        String msg = null;
        Integer code = null;
        try {
            int OrgID = data.getInteger("orgID");
            Iterator<Signuporg> iterator = signuporgs.iterator();
            while (iterator.hasNext()) {
                Signuporg signuporg = iterator.next();
                int signuporgID = signuporg.getOrgid();
                String admission = signuporg.getIsnotadmission();
                if (signuporgID != OrgID || !admission.equals("否")) {
                    iterator.remove();//使用迭代器的删除方法删除
                }
            }
            for(Signuporg signuporg:signuporgs){
                int userID = signuporg.getUserid();
                Users users = this.userService.selectByuserID(userID);
                users.setUpdatetime(signuporg.getSignuporgtime());
                users.setUserphoto(String.valueOf(signuporg.getSignupid()));
                usersList.add(users);
            }
            result.put("usersList", usersList);
        }catch (Exception e){
            msg = "查询报名学生失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        msg = "查询报名学生成功";
        code = 0;
        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }


    //授权学生加入社团
    @UserLoginToken
    @RequestMapping("/empowerOrg")
    @ResponseBody
    public JsonResponseBody empowerOrg(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        Date nowtime = new Date();
        try {
            int signupID = data.getInteger("signupID");
            int userID = data.getInteger("userID");
            int orgID = data.getInteger("orgID");
            Users newuser = new Users();
            newuser.setDefultorg(String.valueOf(orgID));
            newuser.setUpdatetime(nowtime);
            this.userService.updateUserOneInfo(newuser, userID);
            RelationOrgs relationOrgs = new RelationOrgs();
            relationOrgs.setJointime(nowtime);
            relationOrgs.setOrgid(orgID);
            relationOrgs.setUserid(userID);
            relationOrgs.setPosition("成员");
            this.orgService.insertrelationOrgs(relationOrgs);
            Signuporg newsignuporg = new Signuporg();
            newsignuporg.setIsnotadmission("是");
            newsignuporg.setAdmissiontime(nowtime);
            this.orgService.updateSignuporg(newsignuporg,signupID);
            msg = "授权学生加入社团成功";
            code = 0;
        } catch (Exception e) {
            e.printStackTrace();
            msg = "授权学生加入社团失败";
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
