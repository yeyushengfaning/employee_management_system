package com.yeyu.service;

import com.yeyu.pojo.JobOption;

public interface ReportService {
    /**
     * 统计员工职位数据
     * @return 员工职位数据
     */
    JobOption getEmpJobData();

    /**
     * 统计员工性别数据
     * @return 员工性别数据
     */
    Object getEmpGenderData();
}
