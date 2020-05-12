package org.jude.manageBack.service.impl;

import org.jude.manageBack.mapper.IndeximgsMapper;
import org.jude.manageBack.pojo.Indeximgs;
import org.jude.manageBack.pojo.IndeximgsExample;
import org.jude.manageBack.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private IndeximgsMapper indeximgsMapper;

    //搜索出所有主页图片
    @Override
    public List<Indeximgs> findAllIndexImgs() throws Exception {
        IndeximgsExample indeximgsExample = new IndeximgsExample();
        return this.indeximgsMapper.selectByExample(indeximgsExample);
    }

    //按社团id搜索图片
    @Override
    public List<Indeximgs> findImgsbyOrg(int orgID) throws Exception{
        IndeximgsExample example = new IndeximgsExample();
        IndeximgsExample.Criteria criteria = example.createCriteria();
        criteria.andIndeximgownerorgEqualTo(orgID);
        return this.indeximgsMapper.selectByExample(example);
    }

    //添加主页图片
    @Override
    @Transactional
    public void upLoadIndexImgs(Indeximgs indeximgs) throws Exception {
        this.indeximgsMapper.insert(indeximgs);
    }

    //删除主页图片
    @Override
    @Transactional
    public void deleteIndexImgs(String url) throws Exception {
        IndeximgsExample example = new IndeximgsExample();
        IndeximgsExample.Criteria criteria = example.createCriteria();
        criteria.andIndeximgurlEqualTo(url);
        indeximgsMapper.deleteByExample(example);
    }
}

