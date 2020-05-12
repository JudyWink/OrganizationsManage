package org.jude.manageBack.service.impl;

import org.jude.manageBack.mapper.OrgsMapper;
import org.jude.manageBack.pojo.Orgs;
import org.jude.manageBack.pojo.OrgsExample;
import org.jude.manageBack.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgServiceImpl implements OrgService {
    @Autowired
    private OrgsMapper orgsMapper;

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
}
