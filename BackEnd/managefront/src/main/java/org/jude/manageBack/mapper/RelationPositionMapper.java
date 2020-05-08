package org.jude.manageBack.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jude.manageBack.pojo.RelationPosition;
import org.jude.manageBack.pojo.RelationPositionExample;

public interface RelationPositionMapper {
    long countByExample(RelationPositionExample example);

    int deleteByExample(RelationPositionExample example);

    int deleteByPrimaryKey(Integer relationPositionId);

    int insert(RelationPosition record);

    int insertSelective(RelationPosition record);

    List<RelationPosition> selectByExample(RelationPositionExample example);

    RelationPosition selectByPrimaryKey(Integer relationPositionId);

    int updateByExampleSelective(@Param("record") RelationPosition record, @Param("example") RelationPositionExample example);

    int updateByExample(@Param("record") RelationPosition record, @Param("example") RelationPositionExample example);

    int updateByPrimaryKeySelective(RelationPosition record);

    int updateByPrimaryKey(RelationPosition record);
}