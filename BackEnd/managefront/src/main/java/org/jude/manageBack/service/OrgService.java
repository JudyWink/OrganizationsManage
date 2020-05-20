package org.jude.manageBack.service;

import org.jude.manageBack.pojo.Orgs;
import org.jude.manageBack.pojo.RelationOrgs;
import org.jude.manageBack.pojo.Signuporg;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrgService {

    //查找所有社团
    public List<Orgs> findAllOrgs() throws Exception;

    //通过id查找社团
    public Orgs selectByorgID(int orgID) throws Exception;

    //通过社团id查找社团关系
    public List<RelationOrgs> selectRelByorgID(int orgID) throws Exception;

    //修改用户的某个社团关系信息
    public void updaterelationOrgsOneInfo(RelationOrgs relationOrgs,int userID)throws Exception;

    //增加一个社团关系
    public void insertrelationOrgs(RelationOrgs relationOrgs)throws Exception;

    //删除用户社团关系
    public void delrelationOrgsbyuserID(int userID)throws Exception;

    //增加社团报名表信息
    public void insertsignUpOrg(Signuporg signuporg)throws Exception;

    //查询所有社团报名表信息
    public List<Signuporg> findAllsignUpOrg() throws Exception;

    //更新用户的社团报名表信息
    public void updateSignuporg(Signuporg signuporg,int signupID)throws Exception ;
}
