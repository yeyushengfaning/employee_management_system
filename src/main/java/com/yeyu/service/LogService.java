package com.yeyu.service;

import com.yeyu.pojo.OperateLog;
import com.yeyu.pojo.PageResult;

public interface LogService {

    /**
     * 分页查询操作日志
     * @param page 当前页码
     * @param pageSize 每页记录数
     * @return 分页查询结果
     */
    PageResult<OperateLog> page(Integer page, Integer pageSize);
}
