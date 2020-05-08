package org.jude.manageBack.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jude.manageBack.pojo.Documents;
import org.jude.manageBack.pojo.DocumentsExample;

public interface DocumentsMapper {
    long countByExample(DocumentsExample example);

    int deleteByExample(DocumentsExample example);

    int deleteByPrimaryKey(Integer documentid);

    int insert(Documents record);

    int insertSelective(Documents record);

    List<Documents> selectByExample(DocumentsExample example);

    Documents selectByPrimaryKey(Integer documentid);

    int updateByExampleSelective(@Param("record") Documents record, @Param("example") DocumentsExample example);

    int updateByExample(@Param("record") Documents record, @Param("example") DocumentsExample example);

    int updateByPrimaryKeySelective(Documents record);

    int updateByPrimaryKey(Documents record);
}