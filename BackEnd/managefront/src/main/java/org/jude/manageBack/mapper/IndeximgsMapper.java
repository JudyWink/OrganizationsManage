package org.jude.manageBack.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jude.manageBack.pojo.Indeximgs;
import org.jude.manageBack.pojo.IndeximgsExample;

public interface IndeximgsMapper {
    long countByExample(IndeximgsExample example);

    int deleteByExample(IndeximgsExample example);

    int deleteByPrimaryKey(Integer indeximgid);

    int insert(Indeximgs record);

    int insertSelective(Indeximgs record);

    List<Indeximgs> selectByExample(IndeximgsExample example);

    Indeximgs selectByPrimaryKey(Integer indeximgid);

    int updateByExampleSelective(@Param("record") Indeximgs record, @Param("example") IndeximgsExample example);

    int updateByExample(@Param("record") Indeximgs record, @Param("example") IndeximgsExample example);

    int updateByPrimaryKeySelective(Indeximgs record);

    int updateByPrimaryKey(Indeximgs record);
}