package org.jude.manageBack.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jude.manageBack.pojo.Orgs;
import org.jude.manageBack.pojo.OrgsExample;

public interface OrgsMapper {
    long countByExample(OrgsExample example);

    int deleteByExample(OrgsExample example);

    int deleteByPrimaryKey(Integer orgid);

    int insert(Orgs record);

    int insertSelective(Orgs record);

    List<Orgs> selectByExample(OrgsExample example);

    Orgs selectByPrimaryKey(Integer orgid);

    int updateByExampleSelective(@Param("record") Orgs record, @Param("example") OrgsExample example);

    int updateByExample(@Param("record") Orgs record, @Param("example") OrgsExample example);

    int updateByPrimaryKeySelective(Orgs record);

    int updateByPrimaryKey(Orgs record);
}