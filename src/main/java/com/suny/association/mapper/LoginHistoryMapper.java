package com.suny.association.mapper;

import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.LoginHistory;

import java.util.List;
import java.util.Map;

/**
 * Comments:  登陆历史mapper接口映射
 * Author:   孙建荣
 * Create Date: 2017/03/05 23:05
 */

public interface LoginHistoryMapper extends IMapper<LoginHistory> {

    List<LoginHistory> list(Map<Object,Object> criteriaMap);

    int queryCount();
}