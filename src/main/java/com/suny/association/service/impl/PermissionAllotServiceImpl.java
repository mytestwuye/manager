package com.suny.association.service.impl;

import com.suny.association.pojo.po.PermissionAllot;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IPermissionAllotService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Comments:   权限分配业务逻辑实现类
 * Author:   孙建荣
 * Create Date: 2017/05/02 13:10
 */
@Service
public class PermissionAllotServiceImpl extends AbstractBaseServiceImpl<PermissionAllot> implements IPermissionAllotService {
    @Override
    public PermissionAllot queryByName(String name) {
        return null;
    }

    @Override
    public int queryCount() {
        return 0;
    }

    @Override
    public List<PermissionAllot> list(Map<Object, Object> criteriaMap) {
        return null;
    }
}
