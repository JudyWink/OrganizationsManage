package org.jude.manageBack.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jude.manageBack.pojo.Messages;
import org.jude.manageBack.pojo.MessagesExample;

public interface MessagesMapper {
    long countByExample(MessagesExample example);

    int deleteByExample(MessagesExample example);

    int deleteByPrimaryKey(Integer messageid);

    int insert(Messages record);

    int insertSelective(Messages record);

    List<Messages> selectByExample(MessagesExample example);

    Messages selectByPrimaryKey(Integer messageid);

    int updateByExampleSelective(@Param("record") Messages record, @Param("example") MessagesExample example);

    int updateByExample(@Param("record") Messages record, @Param("example") MessagesExample example);

    int updateByPrimaryKeySelective(Messages record);

    int updateByPrimaryKey(Messages record);
}