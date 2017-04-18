package com.suny.association.service.interfaces;

import com.suny.association.pojo.po.ApplicationMessage;
import com.suny.association.pojo.po.CallbackResult;
import com.suny.association.service.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:10
 */
public interface IApplicationMessageService extends IBaseService<ApplicationMessage> {
    int queryCount();
     List<ApplicationMessage> queryAllByCriteria(Map<Object,Object> criteriaMap);

    void updateApplyForResult(ApplicationMessage applicationMessage, CallbackResult callbackResult);
}
