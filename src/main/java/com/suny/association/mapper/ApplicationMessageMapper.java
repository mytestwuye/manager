package com.suny.association.mapper;

import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.ApplicationMessage;

import java.util.List;
import java.util.Map;

/**
 * Comments:   申请修改考勤类型mapper接口映射
 * Author:   孙建荣
 * Create Date: 2017/03/05 23:05
 */

public interface ApplicationMessageMapper extends IMapper<ApplicationMessage> {
    int queryCount();
    List<ApplicationMessage> queryAllByCriteria(Map<Object,Object> criteriaMap);
}