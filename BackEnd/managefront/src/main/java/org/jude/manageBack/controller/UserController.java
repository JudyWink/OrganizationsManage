package org.jude.manageBack.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.jude.manageBack.JsonRequestBody;
import org.jude.manageBack.JsonResponseBody;
import org.jude.manageBack.config.UserLoginToken;
import org.jude.manageBack.pojo.Users;
import org.jude.manageBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //登录
    @RequestMapping("/Login")
    @ResponseBody
    public JsonResponseBody Login(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        String userAcount = data.getString("userAcount");
        String userPassword = data.getString("userPassword");
        List<Users> usersList = this.userService.selectByuserAcount(userAcount);
        if (usersList.isEmpty()) {
            msg = "还没注册";
            code = 1;
        }
        for (Users user : usersList) {
            if (user.getUseracount().equals(userAcount)) {
                if (user.getUserpassword().equals(userPassword)) {
                    String token;
                    token = JWT.create().withAudience(user.getUseracount()).sign(Algorithm.HMAC256(user.getUserpassword()));
                    result.put("token", token);
                    result.put("userType",user.getUsertype());
                    result.put("userName",user.getUsername());
                    code = 0;
                    msg = "登录成功";
                } else {
                    msg = "密码错误";
                    code = 1;
                }
            }
        }
        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //判断是否注册
    @RequestMapping("/findOneUser")
    @ResponseBody
    public JsonResponseBody findOneUser(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg;
        Integer code;
        JsonResponseBody responseBody = new JsonResponseBody();
        String userAcount = data.getString("userAcount");
        List<Users> usersList = this.userService.selectByuserAcount(userAcount);
        if (usersList.isEmpty()) {
            msg = "该账户可以使用";
            code = 0;
        } else {
            msg = "该账户已经被注册了";
            code = 1;
        }
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //注册
    @RequestMapping("/regist")
    @ResponseBody
    public JsonResponseBody regist(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        String userAcount = data.getString("userAcount");
        String userPassword = data.getString("userPassword");
        Users users = new Users();
        List<Users> usersList = this.userService.selectByuserAcount(userAcount);
        if (usersList.isEmpty()) {
            users.setUseracount(userAcount);
            users.setUserpassword(userPassword);
            users.setUsertype("学生");
            users.setUsername(userAcount);
            SimpleDateFormat nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            users.setCreatetime(nowtime.parse(nowtime.format(new Date())));
            this.userService.regist(users);
            msg = "注册成功";
            code = 0;
        } else {
            msg = "该用户已经注册";
            code = 1;
        }
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }


//
//    //查询全部用户
//    @RequestMapping("/findAllUsers")
//    @ResponseBody
//    public JsonResponseBody findAllUsers() throws Exception {
//        List<Users> usersList = this.userService.findAllUsers();
//        JsonResponseBody responseBody = new JsonResponseBody();
//        JSONObject result = new JSONObject();
//        result.put("status", "登录成功");
//        result.put("token", "token");
//        result.put("user",usersList);
//        responseBody.setData(result);
//        return responseBody;
//    }
//


    //模板
    @UserLoginToken
    @RequestMapping("/mb")
    @ResponseBody
    public JsonResponseBody mb(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        result.put("sb","sb");
        msg = "nis";
        code = 2;

        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }


}
