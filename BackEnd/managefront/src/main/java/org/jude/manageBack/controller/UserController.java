package org.jude.manageBack.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.jude.manageBack.JsonRequestBody;
import org.jude.manageBack.JsonResponseBody;
import org.jude.manageBack.config.UserLoginToken;
import org.jude.manageBack.pojo.Orgs;
import org.jude.manageBack.pojo.RelationOrgs;
import org.jude.manageBack.pojo.Users;
import org.jude.manageBack.service.IMailService;
import org.jude.manageBack.service.OrgService;
import org.jude.manageBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrgService orgService;
    @Autowired
    private IMailService iMailService;

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
            msg = "改账号还没注册";
            code = 1;
        }
        for (Users user : usersList) {
            if (user.getUseracount().equals(userAcount)) {
                if (user.getUserpassword().equals(userPassword)) {
                    String token;
                    token = JWT.create().withAudience(user.getUseracount()).sign(Algorithm.HMAC256(user.getUserpassword()));
                    result.put("token", token);
                    result.put("userType", user.getUsertype());
                    result.put("userName", user.getUsername());
                    result.put("userID", user.getUserid());
                    result.put("orgID", user.getDefultorg());
                    String userEmail = user.getUseremail();
                    if (userEmail != null && userEmail.length() != 0) {
                        result.put("userEmail", userEmail);
                    } else {
                        result.put("userEmail", "无");
                    }
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

    //通过账户查找用户信息
    @UserLoginToken
    @RequestMapping("/findUserInfo")
    @ResponseBody
    public JsonResponseBody findUserInfo(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        try {
            int userID = data.getInteger("userID");
            Users user = this.userService.selectByuserID(userID);
            String orgID = user.getDefultorg();
            if (orgID != null) {
                if (orgID.equals("")) {
                    user.setOrgname("【未加入社团】");
                } else {
                    Orgs org = this.orgService.selectByorgID(Integer.parseInt(orgID));
                    user.setOrgname(org.getOrgname());
                }
            } else {
                user.setOrgname("【未加入社团】");
            }
            result.put("user", user);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "查询用户信息出错";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        msg = "查询用户信息成功";
        code = 0;
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


    //查询无组织用户
    @RequestMapping("/findNoOrgAllUsers")
    @ResponseBody
    @UserLoginToken
    public JsonResponseBody findAllUsers() throws Exception {
        List<Users> usersList = this.userService.findAllUsers();
        Iterator<Users> iterator = usersList.iterator();
        while (iterator.hasNext()) {
            Users users = iterator.next();
            String orgID = users.getDefultorg();
            if (users.getUserid() == 1 || orgID != null) {
                if (orgID.equals("")) {

                } else {
                    iterator.remove();//使用迭代器的删除方法删除
                }
            }
        }
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        result.put("usersList", usersList);
        msg = "查询成功";
        code = 0;
        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //查询有组织用户
    @UserLoginToken
    @RequestMapping("/findhaveOrgAllUsers")
    @ResponseBody
    public JsonResponseBody findhaveOrgAllUsers() throws Exception {
        JSONObject result = new JSONObject();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        try {
            List<Users> usersList = this.userService.findAllUsers();
            Iterator<Users> iterator = usersList.iterator();
            while (iterator.hasNext()) {
                Users users = iterator.next();
                if (users.getUserid() == 1 || users.getUserid() == 2 || users.getDefultorg() == null || "".equals(users.getDefultorg())) {
                    iterator.remove();//使用迭代器的删除方法删除
                }
            }
            List<JSONObject> userInfo = new ArrayList<>();
            List<RelationOrgs> relationOrgs = new ArrayList<>();
            for (Users users : usersList) {
                String orgID = users.getDefultorg();
                relationOrgs = this.orgService.selectRelByorgID(Integer.valueOf(orgID));
                Orgs org = this.orgService.selectByorgID(Integer.valueOf(orgID));
                JSONObject userObject = new JSONObject();
                userObject.put("orgName", org.getOrgname());
                userObject.put("username", users.getUsername());
                userObject.put("phone", users.getUserphone());
                userObject.put("userid", users.getUserid());
                for (RelationOrgs relationOrgsList : relationOrgs) {
                    if (relationOrgsList.getUserid().equals(users.getUserid())) {
                        userObject.put("department", relationOrgsList.getDepartment());
                        userObject.put("position", relationOrgsList.getPosition());
                        userObject.put("joinTime", relationOrgsList.getJointime());
                    }
                }
                userInfo.add(userObject);
            }
            result.put("tableData", userInfo);
            result.put("membersCount", usersList.size());
            msg = "查询有组织用户成功";
            code = 0;
        } catch (Exception e) {
            e.printStackTrace();
            msg = "查询有组织用户失败";
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


    //更新用户信息
    @UserLoginToken
    @RequestMapping("/updateUser")
    @ResponseBody
    public JsonResponseBody updateUser(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        JSONObject userInfo = data.getJSONObject("users");
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        Users user = new Users();
        try {
            user.setUserid(userInfo.getInteger("userid"));
            user.setUseracount(userInfo.getString("useracount"));
            user.setUserpassword(userInfo.getString("userpassword"));
            user.setUsertype(userInfo.getString("usertype"));
            user.setDefultorg(userInfo.getString("defultorg"));
            user.setCreatetime(userInfo.getDate("createtime"));
            user.setUsername(userInfo.getString("username"));
            user.setUserclass(userInfo.getString("userclass"));
            user.setUseracademy(userInfo.getString("useracademy"));
            user.setUsernumber(userInfo.getString("usernumber"));
            user.setUserwechat(userInfo.getString("userwechat"));
            user.setUserqq(userInfo.getString("userqq"));
            user.setDormitory(userInfo.getString("dormitory"));
            user.setUseremail(userInfo.getString("useremail"));
            user.setUserphone(userInfo.getString("userphone"));
            user.setUsersex(userInfo.getString("usersex"));
            user.setUserhobby(userInfo.getString("userhobby"));
            Date nowtime = new Date();
            user.setUpdatetime(nowtime);
            this.userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "修改信息失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        msg = "信息修改成功";
        code = 0;
        responseBody.setData(result);
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //更改密码
    @UserLoginToken
    @RequestMapping("/modifyPassword")
    @ResponseBody
    public JsonResponseBody modifyPassword(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        String pass = data.getString("pass");
        String password = data.getString("password");
        int userID = data.getInteger("userID");
        try {
            Users user = this.userService.selectByuserID(userID);
            if (user.getUserpassword().equals(pass)) {
                Users newuser = new Users();
                newuser.setUserpassword(password);
                this.userService.updateUserOneInfo(newuser, userID);
                msg = "密码修改成功，请记住新密码";
                code = 0;
            } else {
                msg = "原密码不正确";
                code = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "密码修改失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //将学生踢出社团
    @UserLoginToken
    @RequestMapping("/fire")
    @ResponseBody
    public JsonResponseBody fire(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        try {
            int userID = data.getInteger("userID");
            this.orgService.delrelationOrgsbyuserID(userID);
            Users newuser = new Users();
            newuser.setDefultorg("");
            this.userService.updateUserOneInfo(newuser, userID);
            msg = "将学生踢出社团成功";
            code = 0;
        } catch (Exception e) {
            e.printStackTrace();
            msg = "将学生踢出社团失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }

    //社团负责人授权成功
    @UserLoginToken
    @RequestMapping("/empower")
    @ResponseBody
    public JsonResponseBody empower(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        try {
            int userID = data.getInteger("userID");
            int orgID = data.getInteger("orgID");
            Users newuser = new Users();
            newuser.setDefultorg(String.valueOf(orgID));
            newuser.setUsertype("社团负责人");
            this.userService.updateUserOneInfo(newuser, userID);
            RelationOrgs relationOrgs = new RelationOrgs();
            Date nowtime = new Date();
            relationOrgs.setJointime(nowtime);
            relationOrgs.setOrgid(orgID);
            relationOrgs.setUserid(userID);
            relationOrgs.setPosition("社团负责人");
            this.orgService.insertrelationOrgs(relationOrgs);
            msg = "社团负责人授权成功";
            code = 0;
        } catch (Exception e) {
            e.printStackTrace();
            msg = "社团负责人授权失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }


    //发送邮件
    @RequestMapping("/sendEmail")
    @ResponseBody
    public JsonResponseBody sendEmail(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        JSONObject result = new JSONObject();
        String SYMBOLS = "0123456789";
        Random RANDOM = new SecureRandom();
        try {
            String userAcount = data.getString("userAcount");
            String email = data.getString("email");

            char[] nonceChars = new char[6];
            for (int index = 0; index < nonceChars.length; ++index) {
                nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
            }
            String VerificationCode = String.valueOf(nonceChars);
            List<Users> users = this.userService.selectByuserAcount(userAcount);
            Users users1 = users.get(0);
            String userEmail = users1.getUseremail();
            if (userEmail != null && userEmail.length() != 0) {
                if (email.equals(userEmail)) {
                    this.iMailService.sendSimpleMail(email, "社团管理系统修改密码", "用户账户[" + userAcount + "]申请忘记密码,验证码是:[" + VerificationCode + "]");
                    result.put("code", VerificationCode);
                    msg = "发送验证码成功，请到登录邮箱接收";
                    code = 0;
                } else {
                    msg = "账户与邮箱不匹配";
                    code = 1;
                    responseBody.setMsg(msg);
                    responseBody.setCode(code);
                    return responseBody;
                }
            } else {
                msg = "该账户还未设置邮箱，请联系管理员";
                code = 1;
                responseBody.setMsg(msg);
                responseBody.setCode(code);
                return responseBody;
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "发送验证码失败";
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


    //忘记密码
    @RequestMapping("/forgetPassword")
    @ResponseBody
    public JsonResponseBody forgetPassword(@RequestBody JsonRequestBody requestBody) throws Exception {
        JSONObject data = requestBody.getData();
        String msg = null;
        Integer code = null;
        JsonResponseBody responseBody = new JsonResponseBody();
        try {
            String password = data.getString("password");
            String userAcount = data.getString("userAcount");
            List<Users> users = this.userService.selectByuserAcount(userAcount);
            Users users1 = users.get(0);
            int userID = users1.getUserid();
            Users newuser = new Users();
            newuser.setUserpassword(password);
            newuser.setUpdatetime(new Date());
            this.userService.updateUserOneInfo(newuser, userID);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "新密码设置失败";
            code = 1;
            responseBody.setMsg(msg);
            responseBody.setCode(code);
            return responseBody;
        }
        msg = "新密码设置成功，请记住新密码";
        code = 0;
        responseBody.setMsg(msg);
        responseBody.setCode(code);
        return responseBody;
    }


}
