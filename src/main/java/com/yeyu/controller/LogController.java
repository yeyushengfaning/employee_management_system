package com.yeyu.controller;

import com.yeyu.pojo.OperateLog;
import com.yeyu.pojo.PageResult;
import com.yeyu.pojo.Result;
import com.yeyu.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 分页查询操作日志
     * @param page 当前页码
     * @param pageSize 每页记录数
     * @return 分页查询结果
     */
    @GetMapping("/log/page")
    public Result logPage(Integer page, Integer pageSize) {
        PageResult<OperateLog> pageResult= logService.page(page, pageSize);
        return Result.success(pageResult);

    }
}
