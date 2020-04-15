package org.jude.manageBack.controller;

import com.alibaba.fastjson.JSONObject;
import org.jude.manageBack.JsonRequestBody;
import org.jude.manageBack.JsonResponseBody;
import org.jude.manageBack.pojo.Users;
import org.jude.manageBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //查询全部用户
    @RequestMapping("/findAllUsers")
    @ResponseBody
    public List<Users> findAllUsers() throws Exception {
            List<Users> usersList = this.userService.findAllUsers();
            System.out.println(usersList);
        return usersList;
    }

    //添加用户
    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(@RequestBody JsonRequestBody requestBody,HttpServletRequest request){
        try{
            Users users = new Users();
            HashMap<String, String>  jsondata = requestBody.getJsonDate();
            System.out.println(requestBody);
            users.setUseracount(jsondata.get("userAcount"));
            users.setUserpassword(jsondata.get("userPassword"));
            SimpleDateFormat nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//
            users.setCreatetime(nowtime.parse(nowtime.format(new Date())));
            this.userService.addUser(users);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "ok";
    }

    //更新用户
    @RequestMapping("/updateUser")
    public String updateUser(Users users){
        return null;
    }


    @ResponseBody
    @RequestMapping("/testResAndReq")
    public String  testResAndReq(@RequestBody(required=false) JsonRequestBody requestBody,
                                 HttpServletRequest request, HttpServletResponse response) {
        String jsonString = null;
        Users usr = new Users();
        usr.setUseracount("12132434324");
        usr.setUserpassword("abcdefq");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("usr", usr);
        JsonResponseBody<Map<String, Object>> responseBody = new JsonResponseBody<>();
        responseBody.setResponseData(map);
        jsonString = JSONObject.toJSONString(responseBody);
        return jsonString;
    }

}
