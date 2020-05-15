package org.jude.manageBack.service.impl;

import org.jude.manageBack.mapper.UsersMapper;
import org.jude.manageBack.pojo.Users;
import org.jude.manageBack.pojo.UsersExample;
import org.jude.manageBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;

    //通过账户查找用户
    @Override
    public List<Users> selectByuserAcount(String userAcount) throws Exception {
        UsersExample usersExample = new UsersExample();
        usersExample.createCriteria().andUseracountEqualTo(userAcount);
        return this.usersMapper.selectByExample(usersExample);
    }
    //通过id查找用户
    public Users selectByuserID(int userID) throws Exception {
        return this.usersMapper.selectByPrimaryKey(userID);
    }

    //添加用户
    @Override
    @Transactional
    public void regist(Users user) throws Exception {
        this.usersMapper.insert(user);
    }

    //查询所有用户
    @Override
    public List<Users> findAllUsers() throws Exception {
        UsersExample usersExample = new UsersExample();
        return this.usersMapper.selectByExample(usersExample);
    }

    //通过ID更新用户信息
    @Override
    public void updateUser(Users user) throws Exception {
        this.usersMapper.updateByPrimaryKey(user);
    }

    //修改用户的某个信息
    @Override
    public void updateUserOneInfo(Users user,int userID)throws Exception {
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userID);
        this.usersMapper.updateByExampleSelective(user,example);
    }

}
