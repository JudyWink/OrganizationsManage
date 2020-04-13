package org.jude.manageBack.controller;

import org.jude.manageBack.pojo.Users;
import org.jude.manageBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public String addUser(Users users){

        try{
            this.userService.addUser(users);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "ok";
    }

    //更新用户
    @RequestMapping("updateUser")
    public String updateUser(Users users){
return null;
    }

}
