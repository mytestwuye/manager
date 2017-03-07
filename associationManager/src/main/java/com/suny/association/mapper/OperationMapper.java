package com.suny.association.mapper;

import com.suny.association.pojo.po.Operation;
import com.suny.association.pojo.po.OperationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationMapper {
    int countByExample(OperationExample example);

    int deleteByExample(OperationExample example);

    int deleteByPrimaryKey(Long operationId);

    int insert(Operation record);

    int insertSelective(Operation record);

    List<Operation> selectByExample(OperationExample example);

    Operation selectByPrimaryKey(Long operationId);

    int updateByExampleSelective(@Param("record") Operation record, @Param("example") OperationExample example);

    int updateByExample(@Param("record") Operation record, @Param("example") OperationExample example);

    int updateByPrimaryKeySelective(Operation record);

    int updateByPrimaryKey(Operation record);
}