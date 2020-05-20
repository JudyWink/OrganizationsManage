package org.jude.manageBack.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jude.manageBack.pojo.Signuporg;
import org.jude.manageBack.pojo.SignuporgExample;

public interface SignuporgMapper {
    long countByExample(SignuporgExample example);

    int deleteByExample(SignuporgExample example);

    int deleteByPrimaryKey(Integer signupid);

    int insert(Signuporg record);

    int insertSelective(Signuporg record);

    List<Signuporg> selectByExample(SignuporgExample example);

    Signuporg selectByPrimaryKey(Integer signupid);

    int updateByExampleSelective(@Param("record") Signuporg record, @Param("example") SignuporgExample example);

    int updateByExample(@Param("record") Signuporg record, @Param("example") SignuporgExample example);

    int updateByPrimaryKeySelective(Signuporg record);

    int updateByPrimaryKey(Signuporg record);
}