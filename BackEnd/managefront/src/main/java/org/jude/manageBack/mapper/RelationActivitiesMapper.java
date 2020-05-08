package org.jude.manageBack.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jude.manageBack.pojo.RelationActivities;
import org.jude.manageBack.pojo.RelationActivitiesExample;

public interface RelationActivitiesMapper {
    long countByExample(RelationActivitiesExample example);

    int deleteByExample(RelationActivitiesExample example);

    int deleteByPrimaryKey(Integer relationActivitiesId);

    int insert(RelationActivities record);

    int insertSelective(RelationActivities record);

    List<RelationActivities> selectByExample(RelationActivitiesExample example);

    RelationActivities selectByPrimaryKey(Integer relationActivitiesId);

    int updateByExampleSelective(@Param("record") RelationActivities record, @Param("example") RelationActivitiesExample example);

    int updateByExample(@Param("record") RelationActivities record, @Param("example") RelationActivitiesExample example);

    int updateByPrimaryKeySelective(RelationActivities record);

    int updateByPrimaryKey(RelationActivities record);
}