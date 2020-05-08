package org.jude.manageBack.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jude.manageBack.pojo.RelationOrgs;
import org.jude.manageBack.pojo.RelationOrgsExample;

public interface RelationOrgsMapper {
    long countByExample(RelationOrgsExample example);

    int deleteByExample(RelationOrgsExample example);

    int deleteByPrimaryKey(Integer relationOrgsId);

    int insert(RelationOrgs record);

    int insertSelective(RelationOrgs record);

    List<RelationOrgs> selectByExample(RelationOrgsExample example);

    RelationOrgs selectByPrimaryKey(Integer relationOrgsId);

    int updateByExampleSelective(@Param("record") RelationOrgs record, @Param("example") RelationOrgsExample example);

    int updateByExample(@Param("record") RelationOrgs record, @Param("example") RelationOrgsExample example);

    int updateByPrimaryKeySelective(RelationOrgs record);

    int updateByPrimaryKey(RelationOrgs record);
}