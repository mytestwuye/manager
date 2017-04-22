package com.suny.association.service.interfaces;

import com.suny.association.pojo.po.LoginHistory;
import com.suny.association.service.IBaseService;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:12
 */
public interface ILoginHistoryService extends IBaseService<LoginHistory> {
    void makeUpLoginInfo(String userAgent, String username, String loginIp, boolean authStatus);
}
