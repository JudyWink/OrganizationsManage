package org.jude.manageBack.service;

import org.jude.manageBack.pojo.Indeximgs;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IndexService {

    //搜索出所有主页图片
    public List<Indeximgs> findAllIndexImgs() throws Exception;

    //按社团id搜索图片
    public List<Indeximgs> findImgsbyOrg(int orgID) throws Exception;

    //添加主页图片
    public void upLoadIndexImgs(Indeximgs indeximgs) throws Exception;

    //删除主页图片
    public void deleteIndexImgs(String url) throws Exception;
}
