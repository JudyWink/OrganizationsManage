package org.jude.manageBack.controller;

import com.alibaba.fastjson.JSONObject;
import org.jude.manageBack.JsonRequestBody;
import org.jude.manageBack.JsonResponseBody;
import org.jude.manageBack.config.UserLoginToken;
import org.jude.manageBack.pojo.Indeximgs;
import org.jude.manageBack.pojo.Orgs;
import org.jude.manageBack.pojo.Users;
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
        for(Orgs Org: orgsList){
            int useid = Org.getOrgleader();
            Users user = this.userService.selectByuserID(useid);
            Org.setLeadername(user.getUsername());
        }
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        result.put("orgsList",orgsList);
        msg = "查询所有社团成功";
        code = 0;
        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //根据ID查询社团
    //模板
    @RequestMapping("/findOneOrg")
    @ResponseBody
    public JsonResponseBody findOneOrg(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        int orgID = data.getInteger("orgID");
        Orgs org = this.orgService.selectByorgID(orgID);
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        result.put("org",org);
        msg = "根据ID查询社团成功";
        code = 0;

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
        int orgID = requestBody.getData().getInteger("orgID");
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        List<Indeximgs> imgsINFO = this.indexService.findImgsbyOrg(orgID);
        List<String> IndexImgsUrls = new ArrayList<String>();
        if (!imgsINFO.isEmpty()) {
            for (Indeximgs list : imgsINFO){
                String url = list.getIndeximgurl();
                IndexImgsUrls.add(url);
            }
            result.put("IndexImgsUrls",IndexImgsUrls);
            result.put("count",imgsINFO.size());
            msg = "查找社团图片成功";
            code = 0;
        }
        else {
            msg = "数据库中没找到社团图片信息";
            code = 1;
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
}
