package org.jude.manageBack.service.impl;

import org.jude.manageBack.mapper.DocumentsMapper;
import org.jude.manageBack.pojo.Documents;
import org.jude.manageBack.pojo.DocumentsExample;
import org.jude.manageBack.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentsMapper documentsMapper;

    //查找全部文件
    @Override
    public List<Documents> findAllDocuments()throws Exception{
        DocumentsExample documentsExample = new DocumentsExample();
        return this.documentsMapper.selectByExample(documentsExample);
    }

    //增加文件
    @Override
    public void uploadDocument(Documents documents) throws Exception{
        this.documentsMapper.insert(documents);
    }

    //修改文件信息
    @Override
    public void updateDocumentInfo(Documents documents,int documentID)throws Exception {
        DocumentsExample documentsExample = new DocumentsExample();
        documentsExample.createCriteria().andDocumentidEqualTo(documentID);
        this.documentsMapper.updateByExampleSelective(documents,documentsExample);
    }

    //通过ID查询文件信息
    @Override
    public Documents findOneDocumentInfo(int documentID) throws Exception {
        return this.documentsMapper.selectByPrimaryKey(documentID);
    }

    //删除文件信息
    @Override
    public void deleteDocuments(int documentID) throws Exception {
         this.documentsMapper.deleteByPrimaryKey(documentID);
    }

}
