package com.yeyu.service.impl;

import com.yeyu.mapper.EmpMapper;
import com.yeyu.pojo.JobOption;
import com.yeyu.pojo.Result;
import com.yeyu.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public JobOption getEmpJobData() {
        //调用mapper方法获取员工职位数据
        List<Map<String, Object>> list = empMapper.countEmpJobData();
        //组装数据并返回
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();

        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }
}
