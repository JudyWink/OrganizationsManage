package org.jude.manageBack.service;

import org.jude.manageBack.pojo.Orgs;
import org.jude.manageBack.pojo.RelationOrgs;
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
}