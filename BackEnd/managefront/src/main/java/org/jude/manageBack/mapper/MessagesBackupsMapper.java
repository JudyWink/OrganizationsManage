package org.jude.manageBack.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jude.manageBack.pojo.MessagesBackups;
import org.jude.manageBack.pojo.MessagesBackupsExample;

public interface MessagesBackupsMapper {
    long countByExample(MessagesBackupsExample example);

    int deleteByExample(MessagesBackupsExample example);

    int deleteByPrimaryKey(Integer messageid);

    int insert(MessagesBackups record);

    int insertSelective(MessagesBackups record);

    List<MessagesBackups> selectByExample(MessagesBackupsExample example);

    MessagesBackups selectByPrimaryKey(Integer messageid);

    int updateByExampleSelective(@Param("record") MessagesBackups record, @Param("example") MessagesBackupsExample example);

    int updateByExample(@Param("record") MessagesBackups record, @Param("example") MessagesBackupsExample example);

    int updateByPrimaryKeySelective(MessagesBackups record);

    int updateByPrimaryKey(MessagesBackups record);
}