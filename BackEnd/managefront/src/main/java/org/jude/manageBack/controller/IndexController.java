package org.jude.manageBack.controller;

import com.alibaba.fastjson.JSONObject;
import org.jude.manageBack.JsonRequestBody;
import org.jude.manageBack.JsonResponseBody;
import org.jude.manageBack.config.UserLoginToken;
import org.jude.manageBack.pojo.Indeximgs;
import org.jude.manageBack.service.IndexService;
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
public class IndexController {
    @Autowired
    private IndexService indexService;

    //查询所有图片
    @RequestMapping("/findAllIndexImgs")
    @ResponseBody
    public JsonResponseBody findAllIndexImgs() throws Exception {
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        List<Indeximgs> imgsINFO = this.indexService.findAllIndexImgs();
        List<String> IndexImgsUrls = new ArrayList<String>();
        if (!imgsINFO.isEmpty()) {
            for (Indeximgs list : imgsINFO){
                if(String.valueOf(list.getIndeximgownerorg()).equals("null")) {
                    String url = list.getIndeximgurl();
                    IndexImgsUrls.add(url);
                }
            }
            if(IndexImgsUrls.size() != 0) {
                result.put("IndexImgsUrls", IndexImgsUrls);
                result.put("count", imgsINFO.size());
                msg = "查找首页图片成功";
                code = 0;
            }else {
                msg = "数据库中没找到首页图片信息";
                code = 1;
            }
        }
        else {
            msg = "数据库中没找到首页图片信息";
            code = 1;
        }
        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    @UserLoginToken
    @RequestMapping("/upLoadIndexImgs")
    @ResponseBody
    public JsonResponseBody upLoadIndexImgs(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        String url = data.getString("url");
        String userAccount = data.getString("userAccount");
        Indeximgs indeximgs = new Indeximgs();
        indeximgs.setIndeximgurl(url);
        SimpleDateFormat nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        indeximgs.setIndeximgcreatetime(nowtime.parse(nowtime.format(new Date())));
        indeximgs.setIndeximgowner(userAccount);
        this.indexService.upLoadIndexImgs(indeximgs);
        msg = "成功设置首页图片";
        code = 0;

        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }


    //模板
    @UserLoginToken
    @RequestMapping("/deleteIndexImgs")
    @ResponseBody
    public JsonResponseBody mb(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        String url = data.getString("url");
        if (!url.isEmpty()){
            this.indexService.deleteIndexImgs(url);
            msg = "图片删除成功";
            code = 0;
        }
        else {
            msg = "错误";
            code = 1;
        }


        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

}
