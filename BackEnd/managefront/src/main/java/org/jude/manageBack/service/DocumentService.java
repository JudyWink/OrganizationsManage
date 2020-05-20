package org.jude.manageBack.service;

import org.jude.manageBack.pojo.Documents;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DocumentService {

    //查找全部文件
    public List<Documents> findAllDocuments()throws Exception;

    //增加文件
    public void uploadDocument(Documents documents) throws Exception;

    //修改文件信息
    public void updateDocumentInfo(Documents documents,int documentID)throws Exception;

    //通过ID查询文件信息
    public Documents findOneDocumentInfo(int documentID) throws Exception;

}
