package com.yeyu.controller;

import com.yeyu.pojo.JobOption;
import com.yeyu.pojo.Result;
import com.yeyu.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 统计员工职位数据
     * @return 员工职位数据
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /**
     * 统计员工性别数据
     * @return 员工性别数据
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        return Result.success(reportService.getEmpGenderData());
    }
}
