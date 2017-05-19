package com.suny.association.mapper;

import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.PunchType;


/**
 * Comments:   考勤类型表mapper映射
 * Author:   孙建荣
 * Create Date: 2017/03/05 23:05
 */

public interface PunchTypeMapper extends IMapper<PunchType> {

    @Override
    PunchType queryByName(String name);
}