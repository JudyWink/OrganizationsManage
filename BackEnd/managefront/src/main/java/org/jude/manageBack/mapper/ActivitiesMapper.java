package org.jude.manageBack.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jude.manageBack.pojo.Activities;
import org.jude.manageBack.pojo.ActivitiesExample;

public interface ActivitiesMapper {
    long countByExample(ActivitiesExample example);

    int deleteByExample(ActivitiesExample example);

    int deleteByPrimaryKey(Integer activitityid);

    int insert(Activities record);

    int insertSelective(Activities record);

    List<Activities> selectByExample(ActivitiesExample example);

    Activities selectByPrimaryKey(Integer activitityid);

    int updateByExampleSelective(@Param("record") Activities record, @Param("example") ActivitiesExample example);

    int updateByExample(@Param("record") Activities record, @Param("example") ActivitiesExample example);

    int updateByPrimaryKeySelective(Activities record);

    int updateByPrimaryKey(Activities record);
}