package com.yeyu.mapper;

import com.yeyu.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    /**
     * 批量插入工作经历
     * @param exprList 工作经历列表
     */
    void insertBatch(List<EmpExpr> exprList);

    /**
     * 根据员工ID批量删除工作经历
     * @param empIds 员工ID数组
     */
    void deleteByEmpIds(List<Integer> empIds);
}
