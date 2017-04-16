package com.suny.association.service.interfaces;

import com.suny.association.pojo.po.LoginHistory;
import com.suny.association.service.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:12
 */
public interface ILoginHistoryService extends IBaseService<LoginHistory> {
     List<LoginHistory> list(Map<Object,Object> criteriaMap);

     int queryCount();
}
