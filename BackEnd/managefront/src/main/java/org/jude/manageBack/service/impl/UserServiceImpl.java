package org.jude.manageBack.service.impl;

import org.jude.manageBack.mapper.UsersMapper;
import org.jude.manageBack.pojo.Users;
import org.jude.manageBack.pojo.UsersExample;
import org.jude.manageBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;

    //查询所有用户
    @Override
    public List<Users> findAllUsers() throws Exception {
        UsersExample usersExample = new UsersExample();
        return this.usersMapper.selectByExample(usersExample);
    }

    //增加用户
    @Override
    @Transactional
    public void addUser(Users user) throws Exception {
        this.usersMapper.insert(user);
    }

    @Override
    public void updateUser(Users user) throws Exception {
    }


    @Override
    public void deleteUser(Integer userid) throws Exception {

    }
}
