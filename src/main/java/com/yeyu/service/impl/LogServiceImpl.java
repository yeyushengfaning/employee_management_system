package com.yeyu.service.impl;

import com.yeyu.mapper.OperateLogMapper;
import com.yeyu.pojo.OperateLog;
import com.yeyu.pojo.PageResult;
import com.yeyu.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public PageResult<OperateLog> page(Integer page, Integer pageSize) {
        long total = operateLogMapper.count();

        int start = (page - 1) * pageSize;
        List<OperateLog> logs = operateLogMapper.list(start, pageSize);

        return new PageResult<>(total, logs);
    }
}
