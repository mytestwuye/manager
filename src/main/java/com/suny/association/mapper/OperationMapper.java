package com.suny.association.mapper;

import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.Operation;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Comments:  操作mapper映射
 * Author:   孙建荣
 * Create Date: 2017/03/05 23:05
 */

public interface OperationMapper extends IMapper<Operation>{

    List<Operation> list(@Param("offset") int offset, @Param("limit") int limit);

    int queryCount();

}