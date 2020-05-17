package org.jude.manageBack.service.impl;

import org.jude.manageBack.mapper.OrgsMapper;
import org.jude.manageBack.mapper.RelationOrgsMapper;
import org.jude.manageBack.pojo.Orgs;
import org.jude.manageBack.pojo.OrgsExample;
import org.jude.manageBack.pojo.RelationOrgs;
import org.jude.manageBack.pojo.RelationOrgsExample;
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
}
