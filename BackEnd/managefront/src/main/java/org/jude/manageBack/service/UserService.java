package org.jude.manageBack.service;

import org.jude.manageBack.pojo.Users;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    //通过账户查找用户
    public List<Users> selectByuserAcount(String userAcount) throws Exception;

    //通过ID查找用户
    public Users selectByuserID(int userID) throws Exception;

    //添加用户
    public void regist(Users user) throws Exception;

    public List<Users> findAllUsers() throws Exception;
//
//    public void updateUser(Users user) throws Exception;
//
//    public void deleteUser(Integer userid) throws Exception;
}
