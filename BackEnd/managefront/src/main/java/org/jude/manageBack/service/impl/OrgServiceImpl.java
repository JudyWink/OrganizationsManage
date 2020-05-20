package org.jude.manageBack.service.impl;

import org.jude.manageBack.mapper.OrgsMapper;
import org.jude.manageBack.mapper.RelationOrgsMapper;
import org.jude.manageBack.mapper.SignuporgMapper;
import org.jude.manageBack.mapper.UsersMapper;
import org.jude.manageBack.pojo.*;
import org.jude.manageBack.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgServiceImpl implements OrgService {
    @Autowired
    private OrgsMapper orgsMapper;
    @Autowired
    private RelationOrgsMapper relationOrgsMapper;
    @Autowired
    private SignuporgMapper signuporgMapper;

    //查询所有社团
    @Override
    public List<Orgs> findAllOrgs() throws Exception{
        OrgsExample orgsExample = new OrgsExample();
        return this.orgsMapper.selectByExample(orgsExample);
    }

    //通过id查找社团
    public Orgs selectByorgID(int orgID) throws Exception {
        return this.orgsMapper.selectByPrimaryKey(orgID);
    }

    //通过社团id查找社团关系
    @Override
    public List<RelationOrgs> selectRelByorgID(int orgID) throws Exception {
        RelationOrgsExample relationOrgsExample = new RelationOrgsExample();
        relationOrgsExample.createCriteria().andOrgidEqualTo(orgID);
        return this.relationOrgsMapper.selectByExample(relationOrgsExample);
    }

    //更新用户的某个社团关系信息
    @Override
    public void updaterelationOrgsOneInfo(RelationOrgs relationOrgs,int userID)throws Exception {
        RelationOrgsExample relationOrgsExample = new RelationOrgsExample();
        relationOrgsExample.createCriteria().andUseridEqualTo(userID);
        this.relationOrgsMapper.updateByExampleSelective(relationOrgs,relationOrgsExample);
    }

    @Override
    //增加一个社团关系
    public void insertrelationOrgs(RelationOrgs relationOrgs)throws Exception{
        this.relationOrgsMapper.insert(relationOrgs);
    }

    //删除用户社团关系
    @Override
    public void delrelationOrgsbyuserID(int userID)throws Exception {
        RelationOrgsExample relationOrgsExample = new RelationOrgsExample();
        relationOrgsExample.createCriteria().andUseridEqualTo(userID);
        this.relationOrgsMapper.deleteByExample(relationOrgsExample);
    }

    //增加社团报名表信息
    @Override
    public void insertsignUpOrg(Signuporg signuporg)throws Exception{
        this.signuporgMapper.insert(signuporg);
    }

    //查询所有社团报名表信息
    @Override
    public List<Signuporg> findAllsignUpOrg() throws Exception{
        SignuporgExample signuporgExample = new SignuporgExample();
        return this.signuporgMapper.selectByExample(signuporgExample);
    }

    //更新用户的社团报名表信息
    @Override
    public void updateSignuporg(Signuporg signuporg,int signupID)throws Exception {
        SignuporgExample signuporgExample = new SignuporgExample();
        signuporgExample.createCriteria().andSignupidEqualTo(signupID);
        this.signuporgMapper.updateByExampleSelective(signuporg,signuporgExample);
    }

}
